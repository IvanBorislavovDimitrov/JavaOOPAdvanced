package callofduty.manager;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.factories.AgentFactory;
import callofduty.factories.MissionFactory;
import callofduty.interfaces.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {

    private Map<String, Agent> agents;
    private Map<String, Mission> missions;
    private MissionControl missionControl;

    public MissionManagerImpl(MissionControl missionControl) {
        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.missionControl = missionControl;
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(0);
        String name = arguments.get(1);

        Agent agent = AgentFactory.create(id, name);

        this.agents.put(id, agent);

        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        double missionRating = Double.parseDouble(arguments.get(2));
        double missionBounty = Double.parseDouble(arguments.get(3));

        Mission mission = MissionFactory.createMission(this.missionControl, missionId, missionRating, missionBounty);
        Agent agent = this.agents.get(agentId);

        this.missions.put(missionId, mission);

        agent.acceptMission(mission);

        return String.format("Assigned %s Mission - %s to Agent - %s",
                mission.getClass().getSimpleName().substring(0, mission.getClass().getSimpleName().indexOf('M')), missionId, agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(0);
        Agent agent = this.agents.get(agentId);

        agent.completeMissions();

        try {
            Field completedMissionsField = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
            completedMissionsField.setAccessible(true);

            Field nonCompletedMissionsField = agent.getClass().getSuperclass().getDeclaredField("nonCompletedMissions");
            nonCompletedMissionsField.setAccessible(true);

            List<Mission> missions = (List<Mission>) completedMissionsField.get(agent);
            List<Mission> nonCompletedMissions = (List<Mission>) nonCompletedMissionsField.get(agent);

            // New Obj
            if (missions.size() >= 3) {
                BountyAgent bountyAgent = new MasterAgent(agent.getId(), agent.getName(), agent.getRating());
                Field bountyAgentCompletedMissionsField = bountyAgent.getClass().getSuperclass().getDeclaredField("completedMissions");
                Field bountyAgentNonCompletedMissionsField = bountyAgent.getClass().getSuperclass().getDeclaredField("nonCompletedMissions");

                if (agent instanceof MasterAgent) {
                    Field missionsMaster = ((MasterAgent) agent).getClass().getDeclaredField("missionsMaster");
                    missionsMaster.setAccessible(true);
                    List<Mission> missionsMasterList = (List<Mission>) missionsMaster.get(((MasterAgent) agent));

                    Field missionsMaster1 = ((MasterAgent) bountyAgent).getClass().getDeclaredField("missionsMaster");
                    missionsMaster1.setAccessible(true);
                    missionsMaster1.set(bountyAgent, missionsMasterList);
                }

                bountyAgentCompletedMissionsField.setAccessible(true);
                bountyAgentNonCompletedMissionsField.setAccessible(true);

                bountyAgentCompletedMissionsField.set(bountyAgent, missions);
                bountyAgentNonCompletedMissionsField.set(bountyAgent, nonCompletedMissions);

//                Field bountyField = bountyAgent.getClass().getDeclaredField("bounty");
//                bountyField.setAccessible(true);
//                double bounty = (double) bountyField.get(bountyAgent);
//
//                for (Mission mission : missions) {
//                    bounty += mission.getBounty();
//                }
//
//                bountyField.set(bountyAgent, bounty);

                this.agents.remove(agentId);
                this.agents.put(bountyAgent.getId(), bountyAgent);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return String.format("Agent - %s:%s has completed all assigned missions.",
                agent.getName(), agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(0);

        Identifiable identifiable = this.agents.get(id);
        if (identifiable == null) {
            identifiable = this.missions.get(id);
            boolean isAvailable = false;
            for (Agent agent : this.agents.values()) {
                try {
                    Field completedMissionsField = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
                    completedMissionsField.setAccessible(true);

                    List<Mission> missions = (List<Mission>) completedMissionsField.get(agent);

                    if (missions.contains(identifiable)) {
                        isAvailable = true;
                    }

                    Mission mission = ((Mission) identifiable);
                    return String.format("%s Mission - %s\n" +
                                    "Status: %s\n" +
                                    "Rating: %.2f\n" +
                                    "Bounty: %.2f", identifiable.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().indexOf('M')),
                            mission.getId(), isAvailable ? "Completed" : "Open", mission.getRating(), mission.getBounty());

                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }

        return identifiable.toString();
    }

    @Override
    public String over(List<String> arguments) {
        return String.format("Novice Agents: %d\n" +
                        "Master Agents: %d\n" +
                        "Assigned Missions: %d\n" +
                        "Completed Missions: %d\n" +
                        "Total Rating Given: %.2f\n" +
                        "Total Bounty Given: $%.2f",
                this.agents.values().stream().filter(x -> x instanceof NoviceAgent).count(),
                this.agents.values().stream().filter(x -> x instanceof MasterAgent).count(),
                this.getTotalAssignedMissions(),
                this.getTotalCompletedMissions(),
                this.agents.values().stream().mapToDouble(a -> a.getRating()).sum(),
                this.getTotalBountyEarned());
    }

    private double getTotalBountyEarned() {
        double bounty = 0;
        try {
            for (Agent agent : this.agents.values()) {
                if (agent instanceof MasterAgent) {
                    Field completedMissionsField = agent.getClass().getDeclaredField("missionsMaster");
                    completedMissionsField.setAccessible(true);

                    List<Mission> missions = (List<Mission>) completedMissionsField.get(agent);

                    for (Mission mission : missions) {
                        bounty += mission.getBounty();
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return bounty;
    }

    private int getTotalAssignedMissions() {
        int completedMissions = 0;
        for (Agent agent : this.agents.values()) {
            try {
                Field completedMissionsField = agent.getClass().getSuperclass().getDeclaredField("completedMissions");
                completedMissionsField.setAccessible(true);

                Field nonCompletedMissionsField = agent.getClass().getSuperclass().getDeclaredField("nonCompletedMissions");
                nonCompletedMissionsField.setAccessible(true);

                List<Mission> missions = (List<Mission>) completedMissionsField.get(agent);
                List<Mission> nonCompletedMissions = (List<Mission>) nonCompletedMissionsField.get(agent);

                completedMissions += missions.size() + nonCompletedMissions.size();

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return completedMissions;
    }

    private int getTotalCompletedMissions() {
        int completedMissions = 0;
        for (Agent agent : this.agents.values()) {
            Field completedMissionsField = null;
            try {
                completedMissionsField = agent.getClass().getSuperclass().getDeclaredField("completedMissions");

                completedMissionsField.setAccessible(true);

                List<Mission> missions = (List<Mission>) completedMissionsField.get(agent);

                completedMissions += missions.size();

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return completedMissions;
    }
}
