public class Cat implements Creature {
    double maxRun, maxJump, distractProb;
    String name;

    public Cat() {
        maxRun = 150.0;
        maxJump = 1.2;
        name = "Кот";
        distractProb = 10;
    }

    public Cat(double maxRun, double maxJump) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        name = "Кот";
        distractProb = 10;
    }

    public boolean run(Road road) {
        int distraction = Main.rand.nextInt(100);
        if (distractProb * road.getLength() / 100 >= distraction) {
            System.out.println("Кот отвлёкся и не пробежал дистанцию");
            return false;
        }
        if (road.getLength() <= maxRun) {
            System.out.printf("Кот пробежал %.4f метров \n", road.getLength());
            return true;
        }
        System.out.println("Кот не смог пробежать так много");
        return false;
    }

    public boolean jump(Wall wall) {
        if (wall.getHeight() <= maxJump) {
            System.out.printf("Кот прыгнул на %.4f метров \n", wall.getHeight());
            return true;
        }
        System.out.println("Кот не смог прыгнуть так высоко");
        return false;
    }

    public String getName() {
        return name;
    }
}
