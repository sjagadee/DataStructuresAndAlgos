package string_arrays_matrix;

import java.util.Arrays;

/**
 * Created by srinivas on 2/3/17.
 */
public class UrlifyString {

    private static String urlify(String str, int length) {
        int count = 0;
        char[] strArray = str.toCharArray();
        for(int i =0; i< length; i++) {
            if(strArray[i] == ' ') {
                count++;
            }
        }

        int newLength = length + count * 2 ;

        for(int i  = length - 1; i >= 0; i--) {
            if(strArray[i] == ' ') {
                strArray[newLength-1] = '0';
                strArray[newLength-2] = '2';
                strArray[newLength-3] = '%';
                newLength -= 3;
            } else {
                strArray[newLength - 1] = strArray[i];
                newLength -= 1;
            }
        }
        return new String(strArray);
    }

    public static void main(String[] args) {
        String str = "you are awesome    ";
        System.out.println(str);
        String a = urlify(str, 15);
        System.out.println(a);
    }
}
