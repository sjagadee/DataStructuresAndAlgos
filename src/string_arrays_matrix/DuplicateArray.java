package string_arrays_matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by srinivas on 2/20/17.
 *
 * Find and return duplicate values in the array to the calling method
 * it should follow this condition 1 <= value <= array length
 */
public class DuplicateArray {
    public static List<Integer> returnDuplicates(int[] arr) {
        Set<Integer> resultSet = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0) {
                resultSet.add(arr[i]);
            } else {
                arr[index] = -arr[index];
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 1, 2, 4, 5, 3};

        List<Integer> res = returnDuplicates(arr);
        for (Integer i : res) {
            System.out.print(i + " ");
        }

    }
}
