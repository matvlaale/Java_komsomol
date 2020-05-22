import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] mas1 = {{"1", "1", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "1", "1", "1", "1"}};
        try {
            System.out.println(sum(mas1));
        } catch (MyArrayDataException e) {
            System.out.println("В массиве не числа! (В ячейке " + e.getX() + ", " + e.getY() + ")");
            //e.printStackTrace();
        } catch (MySizeArrayException e) {
            System.out.println("Массив не соответствует размеру!");
            //e.printStackTrace();
        }
        String[][] mas2 = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"a", "b", "c", "d"}, {"1", "1", "1", "1"}};
        try {
            System.out.println(sum(mas2));
        } catch (MyArrayDataException e) {
            System.out.println("В массиве не числа! (В ячейке " + e.getX() + ", " + e.getY() + ")");
            //e.printStackTrace();
        } catch (MySizeArrayException e) {
            System.out.println("Массив не соответствует размеру!");
            //e.printStackTrace();
        }
        String[][] mas3 = {{"1", "1", "1", "1"}, {"0", "0", "9", "9"}, {"1", "2", "3", "4"}, {"5", "6", "7", "8"}};
        try {
            System.out.println(sum(mas3));
        } catch (MyArrayDataException e) {
            System.out.println("В массиве не числа! (В ячейке " + e.getX() + ", " + e.getY() + ")");
            //e.printStackTrace();
        } catch (MySizeArrayException e) {
            System.out.println("Массив не соответствует размеру!");
            //e.printStackTrace();
        }
    }

    public static int sum(String[][] mas) throws MyArrayDataException, MySizeArrayException {
        int sum = 0;
        if (mas.length != 4 || mas[0].length != 4 || mas[1].length != 4 || mas[2].length != 4 || mas[3].length != 4)
            throw new MySizeArrayException();
        else {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    try {
                        sum += reorganize(mas[i][j]);
                    } catch (MyArrayDataException e) {
                        throw new MyArrayDataException(i + 1, j + 1);
                    }
        }
        return sum;
    }

    public static int reorganize(String str) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - '0';
            if (ch >= 0 && ch <= 9) sum += ch * Math.pow(10, i);
            else throw new MyArrayDataException(0, 0);
        }
        return sum;
    }
}

