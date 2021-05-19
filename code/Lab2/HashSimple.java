import java.util.Arrays;
import java.util.Scanner;

public class HashSimple {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        size = input.nextInt();
        table = new Integer[size];

        System.out.print("Введите числа: ");
        input.nextLine();

        for (int i = 0; i < size; i++) {
            int numbers = input.nextInt();
            hashSimple(numbers, numbers);
        }
//        if (input.hasNextInt()) {
//            int numbers = input.nextInt();
//            hashSimple(numbers, numbers);
//        }

        System.out.println(Arrays.toString(table));

        System.out.print("Введите число для поиска: ");
        input.nextLine();
        int number = input.nextInt();

        findHashSimple(number, number);


//        System.out.println("Введите количество элементов: ");
//        int size = input.nextInt();
//        table = new Integer[size];
//
//        System.out.println("Введите числа: ");
//
//        for (int i = 0; i < size; i++){
//
//        }

    }

    private static Integer[] table;
    private static int size;

    public static void hashSimple(int number, int current){
        if (table[current % size] == null){
            table[current % size] = number;
        } else {                                // если индекс не пуст
            if (current != number + size) {     //проверяем на наличие свободных мест
                hashSimple(number, current + 1); //записываем в следующую ячейку
            } else {
                System.out.println("Таблица заполнена");
            }
        }
    }

    public static int findHashSimple (int number, int current) {
        if (table[current % size] != null) {
            if (table[current % size] == number) {
                System.out.println("Индекс числа равен " + Integer.toString(current % size));
                return current % size;
            } else {
                if (current != number + size) {
                    findHashSimple(number, current + 1);
                } else {
                    System.out.println("Таблица не содержит введенное число");
                }
            }
        } else {
            System.out.println("Таблица не содержит введенное число");
        }
        return -1;
    }

}
