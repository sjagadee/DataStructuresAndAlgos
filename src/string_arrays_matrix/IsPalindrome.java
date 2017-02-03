package string_arrays_matrix;

/**
 * Created by srinivas on 2/3/17.
 *
 * We are checking if these two strings are palindrome of each other or not
 */
public class IsPalindrome {
    private static boolean isPalindrome(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            letters[val] ++;
        }

        for(int i = 0; i < t.length(); i++) {
            int val = t.charAt(i);
            letters[val]--;
            if(letters[val] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "awesome";
        String t = "emosewa";

        boolean res = isPalindrome(s, t);
        System.out.print(res);
    }
}
