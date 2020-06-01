import java.util.*;

public class Main {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    static final int size = 10000000;
    static final int half = size / 2;
    static float[] mas = new float[size];
    static float[] mas1 = new float[half];
    static float[] mas2 = new float[half];

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            mas[i] = 1;
        }

        long a = System.currentTimeMillis();
        nonThreading();
        System.out.println("Один поток: " + (System.currentTimeMillis() - a));
        System.out.println(mas[half - 2] + " " + mas[half - 1] + " " + mas[half] + " " + mas[half + 1]);

        for (int i = 0; i < size; i++) {
            mas[i] = 1;
        }

        a = System.currentTimeMillis();
        threading();
        System.out.println("Многопоточность: " + (System.currentTimeMillis() - a));
        System.out.println(mas[half - 2] + " " + mas[half - 1] + " " + mas[half] + " " + mas[half + 1]);
    }

    public static void nonThreading() {
        for (int i = 0; i < size; i++) {
            mas[i] = (float) (mas[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void threading() {
        System.arraycopy(mas, 0, mas1, 0, half);
        System.arraycopy(mas, half, mas2, 0, half);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < half; i++)
                mas1[i] = (float) (mas1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        });
        Thread t2 = new Thread(() -> {
            for (int i = half; i < size; i++)
                mas2[i - half] = (float) (mas2[i - half] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(mas1, 0, mas, 0, half);
        System.arraycopy(mas2, 0, mas, half, half);
    }
}

class Counting implements Runnable {
    private String name;
    final Object monitor;

    Counting(String name) {
        this.name = name;
        monitor = new Object();
    }

    /*@Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println(name + ": " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
    @Override
    public void run() {
        synchronized (monitor) { // Разные объекты-мониторы для разных действий. (Можно внешнюю синхронизацию)
            for (int i = 0; i < 10; i++)
                System.out.println(name + ": " + i);
        }
    }

    public String getName() {
        return name;
    }
}
