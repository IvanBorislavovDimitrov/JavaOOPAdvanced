package callofduty.factories;

import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;

public final class MissionFactory {

    private MissionFactory() {

    }

    public static Mission createMission(MissionControl missionControl, String id, double rating, double bounty) {
        return missionControl.generateMission(id, rating, bounty);
    }
}
