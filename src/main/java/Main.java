import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       DailyActivity dailyActivity=new DailyActivity();
        dailyActivity.eat(1000);
        dailyActivity.drink(1000);
        dailyActivity.walk(1000);

        System.out.println(dailyActivity.getRemainderDailyStatistics());
    }
}
