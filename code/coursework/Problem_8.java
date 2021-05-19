public class Problem_8 {
    public static String Palindrome(String s) {
        String palindrome = "";
        String substring = "";
        for(int i = 0; i < s.length(); i++) {
            substring = "";
            for(int j = i; j < s.length(); j++) {
                substring += s.charAt(j);
                if(isPalindrome(substring) && substring.length() > palindrome.length()) {
                    palindrome = substring;
                }
            }
        }
        return palindrome;
    }

    public  static  boolean  isPalindrome(String  s) {
        String reverseS = reverseString(s);
        return s.equals(reverseS);
    }

    public static String reverseString(String s) {
        String newS = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            newS += s.charAt(i);
        }
        return newS;
    }
}
