import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GlobalActivity globalActivity=new GlobalActivity();
        globalActivity.getSchedule().put(LocalDate.of(2016,05,15),new DailyActivity());
        globalActivity.getSchedule().put(LocalDate.of(2016,05,15),new DailyActivity());
        System.out.println(globalActivity.getSchedule());
    }
}
