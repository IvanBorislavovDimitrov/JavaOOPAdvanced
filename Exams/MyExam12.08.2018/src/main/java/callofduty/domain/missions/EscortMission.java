package callofduty.domain.missions;

public class EscortMission extends BaseMission {

    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating - rating * 25 / 100, bounty + bounty * 25 / 100);
    }
}
