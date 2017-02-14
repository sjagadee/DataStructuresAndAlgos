package string_arrays_matrix;

/**
 * Created by srinivas on 2/14/17.
 *
 * check if a string is an anagram of another given string
 *
 * eg: aabb <===> baab <==> abba
 */
public class Anagram {

    public static  boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int[] arrOfInts = new int[256];

        for(char c: str1.toCharArray()) {
            arrOfInts[c]++;
        }

        for(char c: str2.toCharArray()) {
            arrOfInts[c]--;
        }

        for(int i: arrOfInts) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcbca";
        String str2 = "acccbb";

        boolean res = isAnagram(str1, str2);

        System.out.print(res);
    }

}
