import java.util.Arrays;
import java.util.Scanner;

public class Problem_1 {

    public static int perimeter (int[] arr, int size) {
        int sum = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i] + arr[i+1] > arr[i+2]) && (arr[i] + arr[i+2] > arr[i+1])
                    && (arr[i+1] + arr[i+2] > arr[i]) && (Square(arr[i], arr[i+1], arr[i+2]))) {

                sum = arr[i] + arr[i+1] + arr[i+2];

            } else {}
        }
        return sum;

    }

    // проверка на нулевую площадь
    public static boolean Square (int a, int b, int c) {
        float p = (a + b + c) / 2;
        float s = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return s != 0;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Укажите длину массива: ");

        int size = input.nextInt();
        int array[] = new int[size];

        if (size > 10000 || size < 3) {

            System.out.println("Количество вводимых элементов должно быть не меньше 3 и не больше 100");

        } else {

            System.out.println("Введите элементы массива:");

            for (int i = 0; i < size; i++) {
                array[i] = input.nextInt();
                if (array[i] < 0 || array[i] > Math.pow(10, 6)) {
                    System.out.println("Вводимые числа не должны быть меньше 0 или больше 10^6");
                    break;
                }
            }

            System.out.println("Максимально возможный периметр равен " + perimeter(array, size));
        }
    }
}
