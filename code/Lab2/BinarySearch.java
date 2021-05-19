import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        int count, num, item, array[], first, last;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество элементов: ");
        num = input.nextInt();

        array = new int[num];

        System.out.println("Введите числа: ");

        for (count = 0; count < num; count++) {
            array[count] = input.nextInt();
        }


//        for (int i = 0; i < array.length + 1; i++) {
//            System.out.print(add(array, 5)[i] + " ");
//        }

        //удаление
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(remove(array, 1)[i] + " ");
        }
        Arrays.sort(array);

        System.out.println();
        System.out.println("Введите элемент для бинарного поиска: ");
        item = input.nextInt();
        first = 0;
        last = num - 1;


        System.out.println();
        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


        binarySearch(array, first, last, item);
    }

    public static int[] add(int[] arr, int item){
        int[] array = new int[arr.length + 1];
        array[arr.length] = item;
        for (int i = 0; i < array.length - 1; i++){
            array[i] = arr[i];
        }
        return array;
    }

    public static int[] remove(int[] arr, int index){
        int[] array = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < array.length + 1; i++){
            if (i == index){
                continue;
            }
            array[j] = arr[i];
            j++;
        }
        return array;
    }

    public static void binarySearch (int[] arr, int first, int last, int item) {
        int position = (first + last) / 2;

        while ((arr[position] != item) && (first <= last)) {

            if (arr[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;

        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
        } else {
            System.out.println("Элемент не найден в массиве");
        }
    }
}
