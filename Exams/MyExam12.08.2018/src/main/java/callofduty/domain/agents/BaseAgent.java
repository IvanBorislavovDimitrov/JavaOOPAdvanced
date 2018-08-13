package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseAgent implements Agent {

    private String id;
    private String name;
    private double rating;
    private List<Mission> nonCompletedMissions;
    private List<Mission> completedMissions;

    protected BaseAgent(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.nonCompletedMissions = new LinkedList<>();
        this.completedMissions = new LinkedList<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.nonCompletedMissions.add(mission);
    }

    @Override
    public void completeMissions() {
        while (!this.nonCompletedMissions.isEmpty()) {
            Mission mission = this.nonCompletedMissions.remove(0);
            this.rating += mission.getRating();
            if (this instanceof MasterAgent) {
                try {
                    Field bountyField = this.getClass().getDeclaredField("bounty");
                    bountyField.setAccessible(true);

                    Field missionsField = this.getClass().getDeclaredField("missionsMaster");
                    missionsField.setAccessible(true);

                    List<Mission> missions = (List<Mission>) missionsField.get(this);
                    missions.add(mission);

                    Double bounty = (Double) bountyField.get(this);
                    bounty += mission.getBounty();
                    missionsField.set(this, missions);

                    bountyField.set(this, bounty);

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            this.completedMissions.add(mission);
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {

        try {
            Field completedMissionsField = this.getClass().getSuperclass().getDeclaredField("completedMissions");
            completedMissionsField.setAccessible(true);
            Field nonCompletedMissionsField = this.getClass().getSuperclass().getDeclaredField("nonCompletedMissions");
            nonCompletedMissionsField.setAccessible(true);

            List<Mission> completedMissions = (List<Mission>) completedMissionsField.get(this);
            List<Mission> nonCompletedMissions = (List<Mission>) nonCompletedMissionsField.get(this);

            return String.format("%s Agent - %s\n" +
                            "Personal Code: %s\n" +
                            "Assigned Missions: %d\n" +
                            "Completed Missions: %d\n" +
                            "Rating: %.2f", this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().indexOf('A')), this.getName(),
                    this.getId(), nonCompletedMissions.size(), completedMissions.size(), this.getRating());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Reflection doesn't work NoviceAgent class");
    }
}
