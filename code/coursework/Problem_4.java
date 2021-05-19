import java.util.ArrayList;
import java.util.Collections;

public class Problem_4 {
    public static void main(String[] args) {
        int[] a = new int[] {2,4,1,2,7,8};
        System.out.println(piles(a));
    }
    public static int piles(int[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < args.length; i++) {
            arr.add(args[i]);
        }
        Collections.sort(arr, Collections.reverseOrder()); //обратный порядок сортировки
        int max = 0;
        for(int i = arr.size(); i > 0; i = i - 3) { //потому что так надо
            max += arr.get(1);
            arr.remove(1);
            arr.remove(0);
            arr.remove(arr.size()-1);
        }
        return max;
    }
}
