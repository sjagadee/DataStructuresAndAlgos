package string_arrays_matrix;

/**
 * Created by srinivas on 2/3/17.
 *
 * We are checking if these two strings are palindrome of each other or not
 *
 * Example for Palindrome is malayalam
 *
 */
public class IsPalindrome {
    public static boolean isPalindromeWithTwoStringsI(String s, String t) {
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

    public static boolean isPalindromeWithTwoStringsII(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        char[] cArr1 = str1.toCharArray();
        char[] cArr2 = str2.toCharArray();

        int start = 0;
        int end = cArr2.length -1;

        while(start < cArr1.length && end >= 0) {
            if(cArr1[start] != cArr2[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeWithOneString(String str) {
        char[] cArr = str.toCharArray();

        int start = 0;
        int end = cArr.length -1;

        while(start < end) {
            if(cArr[start] != cArr[end]) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "malayalam";

        boolean res = isPalindromeWithOneString(string);
        System.out.println("Is the given String " + string + " Palindrome: " + res );


        String s = "awesome";
        String t = "emofewa";

        res = isPalindromeWithTwoStringsII(s, t);
        System.out.println("Are these Strings " + s + " and " + t + " Palindrome: " + res);
    }
}
