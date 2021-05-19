import java.util.ArrayList;
import java.util.Scanner;

public class HashChainingMethod {
    private static Integer[] table;
    private static int size;
    private static ArrayList<Integer> a;
    private static ArrayList<Integer> b;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        size = input.nextInt();
        table = new Integer[size];
        a = new ArrayList<>();
        b = new ArrayList<>();

        System.out.print("Введите числа: ");
        input.nextLine();

        for (int i = 0; i < size; i++) {
            int numbers = input.nextInt();
            chainingMethod(numbers);
        }
//        if (input.hasNextInt()) {
//            int numbers = input.nextInt();
//            hashSimple(numbers, numbers);
//        }

        System.out.println(a.toString());
        System.out.println(b.toString());

        System.out.print("Введите число для поиска: ");
        input.nextLine();
        int number = input.nextInt();

        findChainingMethod(number);
    }

    public static void chainingMethod(int number) {

        if (table[number % size] == null){
            a.add(number);
            b.add(null);
            table[number % size] = a.size() - 1;
        } else {

            int i = table[number % size];

            while (a.get(i) != number || b.get(i) != null){
                if (a.get(i) == number) {
                    System.out.println("Таблица уже содержит это значение");
                } else {
                    if (b.get(i) != null){
                        i = b.get(i);
                    } else {
                        a.add(number);
                        b.add(null);
                    }
                }
            }
        }
    }

    public static int findChainingMethod(int number) {
        if (table[number % size] != null){
            int i = table[number % size];
            while (true) {
                if (a.get(i) == number){
                    System.out.println("Индекс числа равен " + Integer.toString(i));
                    return i;
                } else {
                    if (b.get(i) != null){
                        i = b.get(i);
                    } else System.out.println("Таблица не содержит введенное число");
                    return -1;
                }
            }
        }
        else {
            System.out.println("Таблица не содержит введенное число");
        }
        return -1;
    }
}








//links.set(i, links.size() - 1);