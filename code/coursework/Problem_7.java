public class Problem_7 {
    public static boolean canWin(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char changer = ' ';
        for(int i = 0; i < s1.length(); i++) {
            for(int j = i; j < s1.length(); j++) {

                if(c1[i] > c1[j]) {
                    changer = c1[i];
                    c1[i] = c1[j];
                    c1[j] = changer;
                }

                if(c2[i] > c2[j]) {
                    changer = c2[i];
                    c2[i] = c2[j];
                    c2[j] = changer;
                }
            }
        }
        boolean win1 = true, win2 = true;
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] < c2[i]) {
                win1 = false;
            }
            if(c2[i] < c1[i]) {
                win2 = false;
            }
        }

        return win1 || win2;
    }
}
