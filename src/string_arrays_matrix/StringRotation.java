package string_arrays_matrix;

/**
 * Created by srinivas on 1/27/17.
 *
 * This class has a method that would check if the one string is a rotation of other
 *
 *
 */
public class StringRotation {

    private static boolean isRotation(String str1, String str2) {
        int length = str1.length();

        if(length > 0 && length == str2.length()) {
            String newStr = str1 + str1;
            return isSubString(newStr, str2);
        }
        return false;
    }

    private static boolean isSubString(String str1, String str2) {
        return str1.toLowerCase().contains(str2.toLowerCase());
    }

    public static void main(String[] args) {
        String str1 = "Helloworld";
        String str2 = "oworldhell";

        boolean result = isRotation(str1, str2);

        if(result) {
            System.out.print(str2 + " is a rotation of " + str1);
        } else {
            System.out.print(str2 + " is not a rotation of " + str1);
        }
    }
}
