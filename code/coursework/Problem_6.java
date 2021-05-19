import java.util.ArrayList;

public class Problem_6 {
    public static int[][] newIntervals(int[][] intervals) {
        ArrayList<Integer[]> merges = new ArrayList<>();
        int changer0 = 0, changer1 = 0;
        for(int i = 0; i < intervals.length; i++) {
            for(int j = i; j < intervals.length; j++) {

                if(intervals[j][0] < intervals[i][0]) {
                    changer0 = intervals[j][0];
                    changer1 = intervals[j][1];
                    intervals[j][0] = intervals[i][0];
                    intervals[j][1] = intervals[i][1];
                    intervals[i][0] = changer0;
                    intervals[i][1] = changer1;
                }
            }
        }

        for(int i = 0; i < intervals.length; i++) {
            merges.add(new Integer[]{intervals[i][0], intervals[i][1]});
        }
        while(true) {
            boolean isNotChanged = true;
            //если два шарика пересекаются, меняем первый на их объединение, а второй удаляем
            /*merges.get(i)[1] : i - номер массива, [1] - второй элемент*/
            for(int i = 0; i < merges.size()-1; i++) {
                if(merges.get(i)[1] >= merges.get(i+1)[0]) {
                    merges.set(i, new Integer[]{merges.get(i)[0], merges.get(i+1)[1]});
                    merges.remove(i+1);
                    isNotChanged = false;
                    break;
                }
            }
            if(isNotChanged) {
                break;
            }
        }
        intervals = new int[merges.size()][2]; // массив объединений по два элемента в каждой строке
        //заполняем массив  из листа
        for(int i = 0; i < merges.size(); i++) {
            intervals[i][0] = merges.get(i)[0];
            intervals[i][1] = merges.get(i)[1];
        }
        return intervals;
    }
}
