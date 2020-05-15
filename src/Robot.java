public class Robot implements Creature {
    double maxRun, maxJump;
    String name;
    int charge;

    public Robot() {
        maxRun = 500.0;
        maxJump = 0.5;
        name = "Робот";
        charge = 100;
    }

    public Robot(double maxRun, double maxJump) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        name = "Робот";
        charge = 100;
    }

    public boolean run(Road road) {
        if (road.getLength() <= maxRun) {
            charge -= Math.round(road.getLength() / 10);
            if (charge > 0) {
                System.out.printf("Робот пробежал %.4f метров \n", road.getLength());
                return true;
            } else {
                System.out.printf("Робот смог пробежать лишь %.4f метров и разрядился \n", (road.getLength() + charge * 5));
                charge = 0;
                return false;
            }
        }
        charge -= maxRun / 10;
        System.out.println("Робот не смог пробежать так много");
        if (charge <= 0) System.out.println("Робот разрядился");
        return false;
    }

    public boolean jump(Wall wall) {
        if (wall.getHeight() <= maxJump) {
            charge -= Math.round(wall.getHeight() * 25);
            if (charge > 0) {
                System.out.printf("Робот прыгнул на %.4f метров \n", wall.getHeight());
                return true;
            } else {
                System.out.println("Робот разрядился во время прыжка");
                charge = 0;
                return false;
            }
        }
        charge -= maxJump * 25;
        System.out.println("Робот не смог прыгнуть так высоко");
        if (charge <= 0) System.out.println("Робот разрядился");
        return false;
    }

    public String getName() {
        return name;
    }
}
