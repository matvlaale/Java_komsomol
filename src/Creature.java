public interface Creature {
    boolean run(Road road);

    boolean jump(Wall wall);

    default String getName() {
        return "Создание";
    }
}
