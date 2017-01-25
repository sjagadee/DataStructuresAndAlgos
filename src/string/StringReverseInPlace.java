package string;

/**
 * Created by srinivas on 1/25/17.
 *
 * Reverse a string in place
 *
 * Input: "find you will pain only go you recordings security the into if"
 * Output: "if into the security recordings you go only pain will you find"
 *
 * The method I am following to do it
 * 1. reverse the whole String
 * 2. now we would have whole in reverse order
 * 3. the string would look like "fi otni eht sgnidrocer uoy og ylno niap lliw uoy dnif"
 * 4. finally we try to reverse each string, so it looks like the expected output
 *
 */
public class StringReverseInPlace {
    public static void main(String[] args) {

        String str = "United States of America is in the west";
        String reversedStr = stringReverseInPlace(str);
        System.out.print(str + " -> " + reversedStr);
    }

    // static method that performs string reverse
    public static String stringReverseInPlace(String str) {

        char[] newChar = str.toCharArray();
        int first = 0;
        int last = newChar.length -1;

        // first reverse which reverses the whole string
        strReverse(newChar, first, last);

        int curIndex = 0;
        for(int i = 0; i< newChar.length; i++) {

            // check where each word ends and reverse each word
            if(newChar[i] == ' ') {
                strReverse(newChar, curIndex, i-1);
                curIndex =i+1;
            }

            // this would reverse the last word (length -1 because for that would be last index)
            if(i == newChar.length -1 ) {
                strReverse(newChar, curIndex, i);
            }
        }
        return new String(newChar);
    }

    // private method that performs string reverse
    private static void strReverse(char[] newChar, int first, int last) {

        while(first<last) {
            char temp = newChar[first];
            newChar[first] = newChar[last];
            newChar[last] = temp;

            first++;
            last--;
        }
    }
}
