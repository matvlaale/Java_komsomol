public class Man implements Creature {
    double maxRun, maxJump, fatigue;
    String name;

    public Man() {
        maxRun = 200.0;
        maxJump = 0.7;
        name = "Человек";
        fatigue = 0;
    }

    public Man(double maxRun, double maxJump) {
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        name = "Человек";
        fatigue = 0;
    }

    public boolean run(Road road) {
        int unconsciousness = Main.rand.nextInt(50) + 50;
        if (road.getLength() <= maxRun) {
            fatigue += Math.round(road.getLength() / 15);
            if (unconsciousness > fatigue) {
                System.out.printf("Человек пробежал %.4f метров \n", road.getLength());
                return true;
            } else {
                System.out.println("Человек упал в обморок во время бега");
                return false;
            }
        }
        fatigue += maxRun / 15;
        System.out.println("Человек не смог пробежать так много");
        if (unconsciousness < fatigue) System.out.println("Человек упал в обморок");
        return false;
    }

    public boolean jump(Wall wall) {
        int unconsciousness = Main.rand.nextInt(50) + 50;
        if (wall.getHeight() <= maxJump) {
            fatigue += Math.round(wall.getHeight() * 15);
            if (unconsciousness > fatigue) {
                System.out.printf("Человек прыгнул на %.4f метров \n", wall.getHeight());
                return true;
            } else {
                System.out.println("Человек упал в обморок во время прыжка");
                return false;
            }
        }
        fatigue += maxJump * 15;
        System.out.println("Человек не смог прыгнуть так высоко");
        if (unconsciousness < fatigue) System.out.println("Человек упал в обморок");
        return false;
    }

    public String getName() {
        return name;
    }
}
