public enum DayOfWeek {
    Saturday("Subota"), Friday("Petak"), Wednesday("Četvrtak"), Thursday("Srijeda"),
    Tuesday("Utorak"), Monday("Ponedjeljak"), Sunday("Nedjelja");
    private String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
