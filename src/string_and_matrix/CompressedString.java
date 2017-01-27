package string_and_matrix;

/**
 * Created by srinivas on 1/26/17.
 *
 * Compressed String would return us back the smallest string_and_matrix
 * after the compression is complete, we check if the compressed string_and_matrix is smaller
 * if it is, then we return the compressed string_and_matrix,
 * otherwise we return the string_and_matrix which was passed
 */
public class CompressedString {

    public static String getCompressedString(String str) {

        // Using StringBuilder because its mutable,
        // hence it is better to use it as we are going to append
        StringBuilder newStr = new StringBuilder();
        int count = 0;

        char[] strArray = str.toCharArray();

        // looping the strArray
        for(int i = 0; i < strArray.length; i++) {
            // we are checking if i+1 < strArray.length because i+1 can outside the array
            // and can throw ArrayIndexOutOfBound exception
            if(i+1 < strArray.length && strArray[i] == strArray[i+1]) {
                count++;
            }
            // we are appending count+1 here, we would have not counted the last element
            else if (i+1 < strArray.length && strArray[i] != strArray[i+1]) {
                newStr.append(strArray[i]).append(count+1);
                count = 0;
            }
            // this else condition would check the last char count and append it
            else {
                newStr.append(strArray[i]).append(count+1);
                count = 0;
            }
        }
        return str.length() > newStr.length() ? newStr.toString() : str;
    }

    public static void main(String[] args) {
        String str = "aaabbccc";
        String returnStr = getCompressedString(str);
        System.out.print(returnStr);

    }
}
