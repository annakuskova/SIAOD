import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[][] array2d = new int[50][50];
        Random rand = new Random();

        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 50; j++)
                array2d[i][j] = rand.nextInt(1012);

        /*for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(array2d[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int v : toArray(array2d))
            System.out.print(v);

        System.out.println();
        System.out.println();
        */
        int low = 0;
        int high = toArray(array2d).length - 1;

        /*for (int v : quickSort(toArray(array2d), low, high))
            System.out.print(v);

        System.out.println();
        System.out.println();*/

        for(int[] m : toMatrix(quickSort(toArray(array2d), low, high))) {
            for(int i : m){
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        long time = System.currentTimeMillis();
        quickSort(toArray(array2d), low, high);
        System.out.println(System.currentTimeMillis() - time);
    }


    public static int[] toArray(int[][] arr){
        int[] flat = new int[50 * 50];

        int ctr = 0;
        for (int row = 0; row < 50; row++) {
            for (int col = 0; col < 50; col++) {
                flat[ctr++] = arr[row][col];
            }
        }
        return flat;
    }

    public static int[][] toMatrix(int[] arr){
        int [][] numbers = new int [50][50];

        int m = 0;
        for(int i = 0 ; i < 50 ; i++)
            for(int j = 0 ; j < 50; j++)
                numbers[i][j] = arr[m++];

        return numbers;
    }

    public static int[] quickSort(int[] array, int low, int high) {
        // выбрать опорный элемент
        int middle = low + (high - low) / 2; //вычисляем середниу массива
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызоваем рекурсию для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);

        return array;
    }
}
