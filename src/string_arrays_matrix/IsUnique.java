package string_arrays_matrix;

/**
 * Created by srinivas on 2/3/17.
 *
 * This class has a method which checks if
 * the given string is unique or not and returns boolean value accordingly
 */
public class IsUnique {

    private static boolean isUnique(String str) {

        if(str.length() > 128) {
            return false;
        }

        boolean[] checkChar = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            // converts the value of the string to integer
            int val = str.charAt(i);
            // Checks if the value is true, if so then the char is already present in the list
            // so return false
            if(checkChar[val]) {
                return false;
            }
            checkChar[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "new strig";
        boolean returnVal = isUnique(str);
        System.out.print(returnVal);
    }

}
