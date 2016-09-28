import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {
    DailyActivity activity;

    @Before
    public void createHumanTest() {
        activity = new DailyActivity();
    }

    @Test
    public void drinkTest() {
        activity.drink(1000);
        activity.drink(4000);
        assertEquals(5000, activity.getWater());
    }
    @Test
    public void checkMaxWater(){
        activity.drink(3600);
        assertEquals(Status.EXCESSIVE,activity.getWaterStatus());
    }


    @Test
    public void checkMinWater(){
        activity.drink(1600);
        assertEquals(Status.NOT_ENOUGH,activity.getWaterStatus());
    }

    @Test
    public void stepsLeftTest() {
        activity.walk("08:00", 1000);
        activity.walk("18:00", 1000);
        assertEquals(4000,activity.stepsLeft());
    }


}
