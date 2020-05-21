import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Road testRoad = new Road(100);
        int numObjects = 10;
        Object[] obstacles = new Object[numObjects];
        for (int i = 0; i < numObjects; i++) {
            int wor = rand.nextInt(2);
            if (wor == 1) obstacles[i] = new Wall(rand.nextDouble() * 0.9);
            else obstacles[i] = new Road(rand.nextDouble() * 220);
        }
        Creature[] members = {new Man(), new Cat(), new Robot()};
        boolean[] passed = new boolean[3];
        for (int i = 0; i < 3; i++) {
            passed[i] = true;
        }
        int[] roundEnd = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("На полосе препятствий " + members[i].getName().toLowerCase());
            for (int j = 0; j < numObjects; j++) {
                if (passed[i]) {
                    if (obstacles[j] instanceof Road) passed[i] = members[i].run((Road) obstacles[j]);
                    else passed[i] = members[i].jump((Wall) obstacles[j]);
                    if (!passed[i]) roundEnd[i] = j + 1;
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            if (passed[i]) System.out.println(members[i].getName() + " прошёл всю полосу препятствий!");
            else System.out.println(members[i].getName() + " не смог пройти полосу на " + roundEnd[i] + " препятствии");
        }
        String sday = scanner.next();
        DayOfWeek day = DayOfWeek.Monday;
        switch (sday) {
            case "Monday":
                day = DayOfWeek.Monday;
                break;
            case "Tuesday":
                day = DayOfWeek.Tuesday;
                break;
            case "Thursday":
                day = DayOfWeek.Thursday;
                break;
            case "Wednesday":
                day = DayOfWeek.Wednesday;
                break;
            case "Friday":
                day = DayOfWeek.Friday;
                break;
            case "Saturday":
                day = DayOfWeek.Saturday;
                break;
            case "Sunday":
                day = DayOfWeek.Sunday;
                break;
        }
        System.out.println("Кстати, на сербохорватском (или черногорскосербскобоснийскохорватском) \"" + day + "\" будет \"" + day.getName() + "\"");
        System.out.println(dayOfWeek(day));
    }

    public static String dayOfWeek(DayOfWeek day) {
        if (day == DayOfWeek.Saturday || day == DayOfWeek.Sunday) return "Сегодня выходной";
        else if(day != DayOfWeek.Thursday && day != DayOfWeek.Tuesday) return "Осталось работать " + (day.ordinal() * 8) + " часов";
        else return "Осталось работать " + (day.ordinal() * 8) + " часа";
    }
}

