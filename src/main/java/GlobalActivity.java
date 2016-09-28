import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class GlobalActivity {
    private Map<LocalDate, DailyActivity> schedule = new TreeMap<>();


    public Map<LocalDate, DailyActivity> getSchedule() {
        return schedule;
    }


    public void addEvent(Event type, int value, LocalDate date) {
        DailyActivity activity = null;
        if (schedule.get(date) == null) {
            schedule.put(date, activity = new DailyActivity());
        } else {
            activity = schedule.get(date);
        }
        if (type == Event.WATER) {
            activity.drink(value);
        } else if (type == Event.FOOD) {
            activity.eat(value);
        } else {
            activity.walk(value);
        }
    }

    public DailyActivity getDailyActivityOnDate(LocalDate date) {
        return schedule.get(date);
    }

    public String addWeekReport(LocalDate date) {
        int weekWater = 0;
        int weekFood = 0;
        int weekSteps = 0;
        for (int i = 0; i < 7; i++) {
            weekWater += schedule.get(date.plusDays(i)).getWater();
            weekFood += schedule.get(date.plusDays(i)).getFood();
            weekSteps += schedule.get(date.plusDays(i)).getSteps();
        }
        return "Mean values: water="+weekWater/7+",food="+weekFood/7
                +",steps="+weekSteps/7;
    }
}
