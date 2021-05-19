import java.util.Arrays;

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] sequince = new int[] {2, 5, 1, 3, 7};
        int element = 10;

        Arrays.sort(sequince);
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < sequince.length; i++) {
            System.out.print(sequince[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Индекс числа " + element + " равен " + interpolationSearch(sequince, element));
    }

    public static int interpolationSearch(int[] sequince, int element) {
        int left = 0;
        int right = sequince.length - 1;

        Arrays.sort(sequince);

        for (; sequince[left] < element && element < sequince[right];) {
            if (sequince[left] == sequince[right]) {
                break; //если диапазон сузился до 1 числа, заканчиваем поиск
            }
            //формула интерполяции:
            int index = (element - sequince[left]) * (left - right) / (sequince[left] - sequince[right]) + left;

            if (sequince[index] > element) {
                right = index - 1;
            } else if (sequince[index] < element) {
                left = index + 1;
            } else return index;
        }
        if (sequince[left] == element) return left;
        if (sequince[right] == element) return right;
        return -1;
    }
}
