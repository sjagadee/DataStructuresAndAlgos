package string_arrays_matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srinivas on 2/27/17.
 *
 * This two sum solution would return us with one pair of index in the array which makes
 * two sum
 */
public class TwoSum {
    public static int[] twoSumSolution001(int[] arr, int k) {
        for(int i = 0; i< arr.length-1; i++) {
            for(int j = i+1; j < arr.length ; j++) {
                if(arr[i] + arr[j] == k) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum found");
    }

    public static int[] twoSumSolution002(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            map.put(arr[i], i);
        }
        for(int i = 0; i< arr.length; i++) {
            int compliment = k - arr[i];
            if(map.containsKey(compliment) && map.get(compliment) != i) {
                return new int[] {i, map.get(compliment)};
            }
        }
        throw new IllegalArgumentException("No two sum found");
    }

    public static void main(String[] args) {
        int[] array = {6, 3, 4, 8, 5};
        int[] res = twoSumSolution001(array, 12);
        for(int i: res) {
            System.out.println(i);
        }
    }
}
