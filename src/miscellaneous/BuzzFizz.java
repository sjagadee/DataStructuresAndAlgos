package miscellaneous;

/**
 * Created by srinivas on 2/15/17.
 *
 * Buzz fizz problem
 * multiple of 3 = buzz
 * multiple of 5 = fizz
 * multiple of 3 and 5 = buzzfizz
 */
public class BuzzFizz {

    private static String[] buzzFizz(int size) {
        String[] result =  new String[size];
        for(int i = 0; i < size; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                result[i] = "BuzzFizz";
            } else if(i % 3 == 0) {
                result[i] = "Buzz";
            } else if(i % 5 == 0) {
                result[i] = "Fizz";
            } else {
                result[i] = String.valueOf(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int size = 30;
        String[] res = buzzFizz(size);
        for(String s: res) {
            System.out.print(s + " ");
        }
    }
}
