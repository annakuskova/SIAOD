import java.util.Random;

public class Problem_3 {

    public static void matout(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] m = create(5,6,1,100);
        matout(m);
        System.out.println();
        matout(diagonal(m));
    }

    // метод по созданию матрицы
    public static int[][] create(int m,int n,int minl,int maxl){
        final Random random = new Random();

        int[][] array = new int[m][n];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                array[i][j] = random.nextInt(maxl + Math.abs(minl)) + minl;
            }
        }
        return array;
    }


    public static int[][] diagonal(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sort(a, i, j);
            }
        }
        return a;
    }

    public static void sort (int [][] a, int i, int j) {
        if (i == 0 || j == 0) {}
        else {
            if (a[i][j] < a[i-1][j-1]) {
                int k = a[i][j];
                a[i][j] = a[i-1][j-1];
                a[i-1][j-1] = k;
            }
            sort(a,i-1,j-1);
        }
    }
}
