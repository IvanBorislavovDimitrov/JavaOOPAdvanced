package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class MasterAgent extends BaseAgent implements BountyAgent {

    private double bounty;
    private List<Mission> missionsMaster;

    public MasterAgent(String id, String name, double rating) {
        super(id, name, rating);
        this.bounty = 0;
        this.missionsMaster = new ArrayList<>();
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String toString() {
        return String.format("%s\nBounty Earned: $%.2f", super.toString(), this.getBounty());
    }
}
