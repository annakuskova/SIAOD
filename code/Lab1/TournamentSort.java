import java.util.Random;

public class TournamentSort {
    public static void main(String[] args) {

        int[][] array2d = new int[50][50];
        Random rand = new Random();

        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 50; j++)
                array2d[i][j] = rand.nextInt(1012);


        for(int[] m : toMatrix(sort(toArray(array2d)))) {
            for(int i : m){
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println();

        long time = System.currentTimeMillis();
        sort(toArray(array2d));
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

    public static int[] sort(int[] array) {
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int c;
            for (int a = 1; a < array.length; a = a * 2) {
                for (int k = 0; k * a * 2 < array.length; k++) {
                    if (k * a * 2 + a < array.length) {
                        if (array[k * a * 2 + a] < array[k * a * 2]) {
                            c = array[k * 2 * a + a];
                            array[k * 2 * a + a] = array[k * 2 * a];
                            array[k * 2 * a] = c;
                        }
                    }
                }
            }
            arr[i] = array[0];
            array[0] = Integer.MAX_VALUE;
        }
        return arr;
    }
}
