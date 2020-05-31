import java.util.*;

public class Main {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> mem = new ArrayList<String>();
        mem.add("Putin");
        mem.add("Lennon");
        mem.add("Trump");
        mem.add("Obama");
        mem.add("Putin");
        mem.add("Lenin");
        mem.add("Obama");
        mem.add("Yeltsin");
        mem.add("Merkel");
        mem.add("Obama");
        mem.add("Yeltsin");
        mem.add("Merkel");

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : mem) {
            if(map.putIfAbsent(s, 1) != null){
                map.put(s, map.get(s) + 1);
            }
        }
        System.out.println("Уникальные:");
        for (String s: mem) {
            if(map.get(s) == 1) System.out.print(s + " ");
        }
        System.out.println("\nСколько раз встречаются: ");
        for (HashMap.Entry<String, Integer> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }

        Book myBook = new Book();
        myBook.add("Matveev", "+7(985)155-47-85");
        myBook.add("Mikheev", "8(915)105-07-05");
        myBook.add("Matveev", "+7(919)144-52-16");
        myBook.add("Andreev", "8(916)641-40-41");
        System.out.println("Andreev: " + myBook.get("Andreev"));
        System.out.println("Mikheev: " + myBook.get("Mikheev"));
        System.out.println("Matveev: " + myBook.get("Matveev"));
    }
}

class Book{
    TreeMap<String, String> book = new TreeMap<>();

    public void add(String surn, String number){
        if(book.putIfAbsent(surn, number) != null){
            book.put(surn, book.get(surn) + "\n" + number);
        }
    }

    public String get(String surn){
        return book.get(surn);
    }
}