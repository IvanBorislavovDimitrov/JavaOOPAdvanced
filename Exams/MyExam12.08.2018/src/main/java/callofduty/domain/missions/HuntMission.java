package callofduty.domain.missions;

public class HuntMission extends BaseMission {

    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating + rating * 50 / 100, bounty * 2);
    }
}
