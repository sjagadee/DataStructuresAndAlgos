package string_arrays_matrix;

import java.util.HashSet;

/**
 * Created by srinivas on 2/24/17.
 *
 * consecutive array - we need to find the longest consecutive numbers in the
 * given array and to be returned
 *
 * Here I have used Hash set to remove any duplicates present in the array
 * Step1: Later we traverse the array one by one
 *
 * Step2: We check if the number's previous number is present in the Hash set,
 * if present we continue and not execute step3 and go back to step1
 *
 * Step3: We have a while loop where we check the next element is present in the
 * Hash set, if so we increment the length
 *
 * Step4: Finally we check the length against the current max-element, return
 * the highest value
 */
public class ConsecutiveArrays {
    public static int consecutiveArrays(int[] array) {
        HashSet<Integer> values = new HashSet<>();
        int max = 0;
        for(int i: array) {
            values.add(i);
        }
        for(int i: values) {
            if(values.contains(i-1)) {
                continue;
            }
            int length = 0;
            while(values.contains(i++)) {
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 3, 6};
        int res = consecutiveArrays(array);
        System.out.println(res);
    }

}
