package callofduty.domain.missions;

public class SurveillanceMission extends BaseMission {

    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating - rating * 75 / 100, bounty + bounty * 50 / 100);
    }
}
