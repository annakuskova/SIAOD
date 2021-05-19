
import java.util.*;

class Problem_2 {
    // Основная функция, которая печатает
    // расположение с наибольшим значением.
    // Функция принимает вектор строк.

    static void printLargest(Vector<String> arr){
        Collections.sort(arr, new Comparator<String>(){
            // Функция сравнения, которая использует sort () в printLargest ()
            @Override
            public int compare(String X, String Y) {
                String XY= X + Y;       // сначала добавляем Y в конце X
                String YX= Y + X;       // потом добавляем X в конце Y

                // Смотрим, какое из двух сформированных чисел лучше
                return XY.compareTo(YX) > 0 ? -1:1;
            }
        });

        Iterator it = arr.iterator();

        while(it.hasNext())

            System.out.print(it.next());
    }


    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Укажите длину массива: ");

        int size = input.nextInt();
        int[] array = new int[size];

        if (size > 100 || size < 1) {

            System.out.println("Количество вводимых элементов должно быть не меньше 1 и не больше 100");

        } else {

            System.out.println("Введите элементы массива:");

            Vector<String> arr;
            arr = new Vector<>();

            for (int i = 0; i < size; i++) {

                array[i] = input.nextInt();
                String b = String.valueOf(array[i]);
                arr.add(b);

                if (array[i] < 0 || array[i] > Math.pow(10, 9)) {
                    System.out.println("Вводимые числа не должны быть меньше 0 или больше 10^9");
                    break;
                }
            }

            printLargest(arr);
        }
    }
}