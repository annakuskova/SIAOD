import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HashRandom {

    private static Integer[] table;
    private static int size;
    private static ArrayList<Integer> random;

    public static void main(String[] args) {

        table = new Integer[size];
        random = new ArrayList<>();
        for (int i = 0; i < size; i++){
            while (true) {
                int num = (int)(Math.random() * size);
                if (!random.contains(num)){
                    random.add(num);
                    break;
                }
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        size = input.nextInt();

        System.out.print("Введите числа: ");
        input.nextLine();



        for (int i = 0; i < size; i++) {
            int numbers = input.nextInt();
            hashRandom(numbers, 0);
        }

        System.out.println(Arrays.toString(table));

        System.out.print("Введите число для поиска: ");
        input.nextLine();
        int number = input.nextInt();

        findHasgRandom(number, 0);
    }

    public static void hashRandom (int number, int index) {
        if (table[number % size] == null) {
            table[number % size] = number;
        } else {
            if (table[random.get(index)] == null) {
                table[random.get(index)] = number;
            } else {
                if (index + 1 < random.size() - 1) {
                    hashRandom(number, index + 1);
                } else {
                    System.out.println("Таблица заполнена");
                }
            }
        }
    }

    public static int findHasgRandom(int number, int index){
        if (table[number % size] != null){
            if (table[number % size] == number){
                System.out.println("Индекс числа равен " + Integer.toString(number % size));
                return number % size;
            } else {
                if (table[random.get(index)] != null){
                    if (table[random.get(index)] == number){
                        System.out.println("Индекс числа равен " + Integer.toString(random.get(index)));
                        return random.get(index);
                    } else {
                        if (index + 1 < random.size() - 1){
                            findHasgRandom(number, index + 1);
                        } else {
                            System.out.println("Таблица не содержит введенное число");
                        }
                    }
                } else {
                    System.out.println("Таблица не содержит введенное число");
                }
            }
        }  else {
            System.out.println("Таблица не содержит введенное число");
        }
        return -1;
    }


}
