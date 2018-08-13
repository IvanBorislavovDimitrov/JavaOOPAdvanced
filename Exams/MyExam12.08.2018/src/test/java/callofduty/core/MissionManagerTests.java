package callofduty.core;

import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MissionManagerTests {

    private static final Integer MISSION_ID_MAXIMUM_LENGTH = 8;

    private static final Double MISSION_RATING_MINIMUM_VALUE = 0D;

    private static final Double MISSION_RATING_MAXIMUM_VALUE = 100D;

    private static final Double MISSION_BOUNTY_MINIMUM_VALUE = 0D;

    private static final Double MISSION_BOUNTY_MAXIMUM_VALUE = 100000D;

    private MissionControl missionControl;

    @Before
    public void setUp() throws Exception {
        this.missionControl = new MissionControlImpl();
    }

    @Test
    public void testConstants() throws Exception {
        Field mission_id_maximum_length = this.missionControl.getClass().getDeclaredField("MISSION_ID_MAXIMUM_LENGTH");
        mission_id_maximum_length.setAccessible(true);

        Field mission_rating_minimum_value = this.missionControl.getClass().getDeclaredField("MISSION_RATING_MINIMUM_VALUE");
        mission_rating_minimum_value.setAccessible(true);

        Field mission_rating_maximum_value = this.missionControl.getClass().getDeclaredField("MISSION_RATING_MAXIMUM_VALUE");
        mission_rating_maximum_value.setAccessible(true);

        Field mission_bounty_minimum_value = this.missionControl.getClass().getDeclaredField("MISSION_BOUNTY_MINIMUM_VALUE");
        mission_bounty_minimum_value.setAccessible(true);

        Field mission_bounty_maximum_value = this.missionControl.getClass().getDeclaredField("MISSION_BOUNTY_MAXIMUM_VALUE");
        mission_bounty_maximum_value.setAccessible(true);

        Assert.assertEquals(MISSION_ID_MAXIMUM_LENGTH, mission_id_maximum_length.get(this.missionControl));
        Assert.assertEquals(MISSION_RATING_MINIMUM_VALUE, mission_rating_minimum_value.get(this.missionControl));
        Assert.assertEquals(MISSION_RATING_MAXIMUM_VALUE, mission_rating_maximum_value.get(this.missionControl));
        Assert.assertEquals(MISSION_BOUNTY_MINIMUM_VALUE, mission_bounty_minimum_value.get(this.missionControl));
        Assert.assertEquals(MISSION_BOUNTY_MAXIMUM_VALUE, mission_bounty_maximum_value.get(this.missionControl));
    }

    @Test
    public void checkAndReformMissionRating() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndReformMissionRating", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        double real = (double) checkAndReformMissionRatingMethod.invoke(this.missionControl, 20D);

        Assert.assertEquals(20D, real, 0.1);
    }

    @Test
    public void checkAndReformMissionRating1() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndReformMissionRating", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        double real = (double) checkAndReformMissionRatingMethod.invoke(this.missionControl, -20D);

        Assert.assertEquals(0, real, 0.1);
    }

    @Test
    public void checkAndReformMissionRating3() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndReformMissionRating", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        double real = (double) checkAndReformMissionRatingMethod.invoke(this.missionControl, 120D);

        Assert.assertEquals(100, real, 0.1);
    }

    @Test
    public void checkAndreformMissionBounty() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndreformMissionBounty", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        double real = (double) checkAndReformMissionRatingMethod.invoke(this.missionControl, 20D);

        Assert.assertEquals(20, real, 0.1);
    }

    @Test
    public void checkAndreformMissionBounty1() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndreformMissionBounty", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        double real = (double) checkAndReformMissionRatingMethod.invoke(this.missionControl, -20D);

        Assert.assertEquals(0, real, 0.1);
    }

    @Test
    public void checkAndreformMissionBounty2() throws Exception {
        Method checkAndReformMissionRatingMethod = this.missionControl.getClass().getDeclaredMethod("checkAndreformMissionBounty", Double.class);
        checkAndReformMissionRatingMethod.setAccessible(true);

        double real = (double) checkAndReformMissionRatingMethod.invoke(this.missionControl, 120000D);

        Assert.assertEquals(MISSION_BOUNTY_MAXIMUM_VALUE, real, 0.1);
    }

    @Test
    public void checkDefault() throws Exception {
        Field missionControl = this.missionControl.getClass().getDeclaredField("missionClasses");
        missionControl.setAccessible(true);

        Map<String, Class> missionClasses = (Map<String, Class>) missionControl.get(this.missionControl);
        Class expect1 = Class.forName("callofduty.domain.missions.EscortMission");
        Class expect2 = Class.forName("callofduty.domain.missions.HuntMission");
        Class expect3 = Class.forName("callofduty.domain.missions.SurveillanceMission");

        Assert.assertEquals(missionClasses.get("EscortMission"), expect1);
        Assert.assertEquals(missionClasses.get("HuntMission"), expect2);
        Assert.assertEquals(missionClasses.get("SurveillanceMission"), expect3);
    }

    @Test
    public void generateMission1() {
        String missionId = "1";
        Double missionRating = 20D;
        Double missionBounty = 30D;

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);

        Assert.assertTrue(mission instanceof EscortMission);
        Assert.assertEquals(mission.getId(), missionId);
        Assert.assertEquals(mission.getRating(), 15.0, 0.1);
        Assert.assertEquals(mission.getBounty(), 37.5, 0.1);
    }

    @Test
    public void generateMission2() {
        String missionId = "1";
        Double missionRating = 20D;
        Double missionBounty = 30D;

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);
        Mission mission1 = this.missionControl.generateMission("2", missionRating, missionBounty);

        Assert.assertTrue(mission1 instanceof HuntMission);
        Assert.assertEquals(mission1.getId(), "2");
        Assert.assertEquals(30D, mission1.getRating(), 0.1);
        Assert.assertEquals(60D, mission1.getBounty(), 0.1);
    }

    @Test
    public void generateMission3() {
        String missionId = "1";
        Double missionRating = 20D;
        Double missionBounty = 30D;

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);
        Mission mission1 = this.missionControl.generateMission("2", missionRating, missionBounty);
        Mission mission2 = this.missionControl.generateMission("3", missionRating, missionBounty);

        Assert.assertTrue(mission2 instanceof SurveillanceMission);
        Assert.assertEquals(mission2.getId(), "3");
        Assert.assertEquals(5.0, mission2.getRating(), 0.1);
        Assert.assertEquals(45.0, mission2.getBounty(), 0.1);
    }

    @Test
    public void generateMission4BackToNormal() {
        String missionId = "4";
        Double missionRating = 20D;
        Double missionBounty = 30D;

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);
        Mission mission1 = this.missionControl.generateMission("2", missionRating, missionBounty);
        Mission mission2 = this.missionControl.generateMission("3", missionRating, missionBounty);
        Mission mission3 = this.missionControl.generateMission("3", missionRating, missionBounty);

        Assert.assertTrue(mission3 instanceof EscortMission);
        Assert.assertEquals(mission.getId(), missionId);
        Assert.assertEquals(mission.getRating(), 15.0, 0.1);
        Assert.assertEquals(mission.getBounty(), 37.5, 0.1);
    }

    @Test
    public void testIterator() throws Exception {
        Field missionIterator = this.missionControl.getClass().getDeclaredField("missionIterator");
        missionIterator.setAccessible(true);
        Iterator<Map.Entry<String, Class>> iterator = (Iterator<Map.Entry<String, Class>>) missionIterator.get(this.missionControl);

        String[] arr = new String[]{"EscortMission", "HuntMission", "SurveillanceMission"};
        Class[] classes = new Class[]{Class.forName("callofduty.domain.missions.EscortMission"),
                Class.forName("callofduty.domain.missions.HuntMission"),
                Class.forName("callofduty.domain.missions.SurveillanceMission")};

        int index = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, Class> next = iterator.next();
            Assert.assertEquals(arr[index], next.getKey());
            Assert.assertEquals(classes[index], next.getValue());
            index++;

        }
    }

    @Test
    public void instantiateMissionObject() throws Exception {
        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("instantiateMissionObject",
                String.class, Double.class, Double.class);

        instantiateMissionObject.setAccessible(true);

        Mission mission = (Mission) instantiateMissionObject.invoke(this.missionControl, "Nema", 1D, 20D);

        Assert.assertTrue(mission instanceof EscortMission);
        Assert.assertEquals(mission.getId(), "Nema");
        Assert.assertEquals(0.75, mission.getRating(), 0.1);
        Assert.assertEquals(25.0, mission.getBounty(), 0.1);
    }

    @Test
    public void currentMission() throws Exception {
        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("currentMission");
        instantiateMissionObject.setAccessible(true);

        Assert.assertEquals(Class.forName("callofduty.domain.missions.EscortMission"), instantiateMissionObject.invoke(this.missionControl));
    }

    @Test
    public void currentMission1() throws Exception {
        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("currentMission");
        instantiateMissionObject.setAccessible(true);
        instantiateMissionObject.invoke(this.missionControl);

        Assert.assertEquals(Class.forName("callofduty.domain.missions.HuntMission"), instantiateMissionObject.invoke(this.missionControl));
    }

    @Test
    public void currentMission2() throws Exception {
        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("currentMission");
        instantiateMissionObject.setAccessible(true);
        instantiateMissionObject.invoke(this.missionControl);
        instantiateMissionObject.invoke(this.missionControl);

        Assert.assertEquals(Class.forName("callofduty.domain.missions.SurveillanceMission"), instantiateMissionObject.invoke(this.missionControl));
    }

    @Test
    public void updateMissionType() throws Exception {
        Method updateMissionType = this.missionControl.getClass().getDeclaredMethod("updateMissionType");
        updateMissionType.setAccessible(true);

        Method instantiateMissionObject = this.missionControl.getClass().getDeclaredMethod("currentMission");
        instantiateMissionObject.setAccessible(true);
        instantiateMissionObject.invoke(this.missionControl);
        instantiateMissionObject.invoke(this.missionControl);

        updateMissionType.invoke(this.missionControl);

        Assert.assertEquals(Class.forName("callofduty.domain.missions.EscortMission"), instantiateMissionObject.invoke(this.missionControl));
    }

    @Test
    public void testId() throws Exception {
        Double missionRating = 20D;
        Double missionBounty = 30D;

        Mission mission = this.missionControl.generateMission("111111111111", missionRating, missionBounty);

        Assert.assertTrue(mission instanceof EscortMission);
        Assert.assertEquals("11111111", mission.getId());
        Assert.assertEquals(15.0, mission.getRating(), 0.1);
        Assert.assertEquals(37.5, mission.getBounty(), 0.1);
    }
}
