import java.time.LocalDate;

public class DailyActivity {
    /**
     * max daily indices of steps, water, food
     */

    private int max_water=3500;
    private int max_food=2600;
    private int max_steps=12000;



    private int min_water=2000;
    private int min_food=1300;
    private int min_steps=6000;
    /**
     * current indices of steps, water, food
     */
    private int steps;
    private int water;
    private int food;
    private Status waterStatus;
    private Status stepsStatus;
    private Status foodStatus;
    private LocalDate date=LocalDate.now();

    public void walk(int step_number) {
       steps+=step_number;
        updateStatus();
    }
    public void walk(String time,int step_number) {
        steps+=step_number;
    }


    public void drink(int water_milliliters) {
        water+=water_milliliters;
        updateStatus();
    }
    public void drink(String time,int water_milliliters) {
        water+=water_milliliters;
    }

    public void eat(int kCalories) {
        food+=kCalories;
        updateStatus();
    }
    public void eat(String time, int kCalories) {
        food+=kCalories;
    }



    public int stepsLeft() {
        return min_steps-steps;
    }
    public int waterLeft() {
        return min_water-water;
    }
    public int foodLeft() {
        return min_food-food;
    }

    public void updateStatus() {
        if (water<max_water && water>min_water){waterStatus=Status.NORM;}
        else if (water<min_water){waterStatus=Status.NOT_ENOUGH;}
        else {waterStatus=Status.EXCESSIVE;}//(water>max_water)

        if (food<max_food && food>min_food){foodStatus=Status.NORM;}
        else if (food<min_food){foodStatus=Status.NOT_ENOUGH;}
        else {foodStatus=Status.EXCESSIVE;}//(food>max_food)

        if (steps<max_steps && food>min_steps){stepsStatus=Status.NORM;}
        else if (steps<min_steps){stepsStatus=Status.NOT_ENOUGH;}
        else {stepsStatus=Status.EXCESSIVE;}//(steps>max_steps)
    }

    public Status getWaterStatus() {
        return waterStatus;
    }

    public Status getStepsStatus() {
        return stepsStatus;
    }

    public Status getFoodStatus() {
        return foodStatus;
    }
    public int getSteps() {
        return steps;
    }

    public int getWater() {
        return water;
    }

    public int getFood() {
        return food;
    }

    public String badStatuses(){
        //вивести ненормальні статуси
        StringBuilder badStatus=new StringBuilder();
        if (waterStatus==Status.NOT_ENOUGH){
            badStatus.append("WaterStatus "+Status.NOT_ENOUGH);
        }else  if (waterStatus==Status.EXCESSIVE){
            badStatus.append("WaterStatus "+Status.EXCESSIVE);
        }
        if (foodStatus==Status.NOT_ENOUGH){
            badStatus.append("FoodStatus "+Status.NOT_ENOUGH);
        }else  if (foodStatus==Status.EXCESSIVE){
            badStatus.append("FoodStatus "+Status.EXCESSIVE);
        }
        if (stepsStatus==Status.NOT_ENOUGH){
            badStatus.append("StepsStatus "+Status.NOT_ENOUGH);
        }else  if (stepsStatus==Status.EXCESSIVE){
            badStatus.append("StepsStatus "+Status.EXCESSIVE);
        }
            return badStatus.toString();
    }

    //вивести статистику
    public String getDailyStatistics(){
        StringBuilder dailyStatistics=new StringBuilder();
        dailyStatistics.append("Daily consumed water: "+water+"/n");
        dailyStatistics.append("Daily consumed food: "+food+"/n");
        dailyStatistics.append("Daily consumed steps: "+steps+"/n");
        return dailyStatistics.toString();
    }

    public LocalDate getDate() {
        return date;
    }
}
