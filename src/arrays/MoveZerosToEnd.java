package arrays;

/**
 * Created by srinivas on 1/29/17.
 *
 * This class would have a array which contains zero and non-zero elements
 * So, we need to re-arrange the array in such a way that non-zero elements
 * should be contagiously stored which is followed by zero elements, the
 * order of the numbers should not very
 *
 * Example:
 * input array = {10, 4, 0, 0, 12, 1, 15, 0, 8}
 * output array = {10, 4, 12, 1, 15, 8, 0, 0, 0}
 *
 */
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {5, 0, 4, 10, 0, 1};
        int length = arr.length;

        System.out.println("Original array:");
        for(int i = 0; i < length; i++) {
            System.out.print(arr[i] + " " );
        }
        System.out.println();

        moveZerosToEnd(arr, length);

        System.out.println("Zeros at the end array:");
        for(int i = 0; i < length; i++) {
            System.out.print(arr[i] + " " );
        }
    }

    private static void moveZerosToEnd(int[] arr, int length) {
        // create count and initialize it to 0
        int count = 0;

        // loop till i is less than the length
        for(int i = 0; i< length; i ++) {
            // for all non-zero elements
            if(arr[i] != 0) {
                // store arr[i] elements to arr[count++] elements
                // this puts all the non-zero elements at the first part of the array
                arr[count++] = arr[i];
            }
        }

        // now till the count is less than length
        while(count < length) {
            // we add zero to arr[count++]
            // this completes the last part of the array with zeros
            arr[count++] = 0;
        }
    }
}
