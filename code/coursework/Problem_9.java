import java.util.ArrayList;

public class Problem_9 {
    public static int concatenations(String s) {
        int count = 0;
        ArrayList<String> substrings = new ArrayList<>();
        String substring = "";
        for(int i = 0; i < s.length(); i++) {
            substring = "";
            for(int j = i; j < s.length(); j++) {
                substring += s.charAt(j);
                if(substring.length() % 2 == 0) {
                    if(!substrings.contains(substring) && substring.equals(substring.substring(0, substring.length()/2) + substring.substring(0, substring.length()/2))) {
                        substrings.add(substring);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
