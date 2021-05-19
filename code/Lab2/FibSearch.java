import java.util.Arrays;

public class FibSearch {
    private int i, p, q;
    private boolean stop = false;

    public FibSearch() {}

    private void init(int[] sequince) {
        stop = false;
        int k = 0;
        int n = sequince.length;
        for (; getFibonacciNumber(k + 1) < n + 1;) {
            k += 1;
        }
        int m = (int) (getFibonacciNumber(k + 1) - (n + 1));
        i = (int) getFibonacciNumber(k) - m;
        p = (int) getFibonacciNumber(k - 1);
        q = (int) getFibonacciNumber(k - 2);
    }

    //для вычисления чисел Фибоначчи
    public long getFibonacciNumber(int k) {
        long firstNumber = 0;
        long secondNumber = 1;
        for (int i = 0; i < k; i++) {
            long temp = secondNumber;
            secondNumber += firstNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

    //переход к следующему индексу
    private void upIndex() {
        if (p == 1)
            stop = true;
        i = i + q;
        p = p - q;
        q = q - p;
    }

    //переход к предыдущему индексу
    private void downIndex() {
        if (q == 0)
            stop = true;
        i = i - q;
        int temp = q;
        q = p - q;
        p = temp;
    }

    public int search(int[] sequince, int element) {
        init(sequince);
        int n = sequince.length;
        int resultIndex = -1;
        for (; !stop;) {
            if (i < 0) {
                upIndex();
            } else if (i >= n) {
                downIndex();
            } else if (sequince[i] == element) {
                resultIndex = i;
                break;
            } else if (element < sequince[i]) {
                downIndex();
            } else if (element > sequince[i]) {
                upIndex();
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        int[] sequince = new int[] {0, 3, 5, 7, 9, 11, 15, 18, 21};
        int element = 7;

        Arrays.sort(sequince);
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < sequince.length; i++) {
            System.out.print(sequince[i] + " ");
        }
        System.out.println();
        System.out.println();

        FibSearch fs = new FibSearch();

        int index = fs.search(sequince, element);

        System.out.println("Индекс числа " + element + " равен " + index);
    }


}
