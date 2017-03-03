package string_arrays_matrix;

import java.util.*;

/**
 * Created by srinivas on 3/3/17.
 */
public class TwoSumMultiplePairs {

    // this solution would take O(n^2) time complexity
    public static ArrayList<int[]> twoSum(int[] arr, int k) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    result.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return result;
    }

    // this solution would take O(n) time and O(n) space
    public static ArrayList<int[]> twoSumHashSet(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        ArrayList<int[]> result = new ArrayList<>();

        for (int i : arr) {
            int compliment = k - i;

            if (!set.contains(compliment)) {
                set.add(i);
            } else {
                result.add(new int[]{i, compliment});
            }
        }
        return result;
    }

    // this solution would take O(N log n) time
    public static ArrayList<int[]> twoSumOnePass(int[] arr, int k) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length -1;
        while(start < end) {
            if(arr[start] + arr[end] == k) {
                res.add(new int[] {arr[start], arr[end]});
                start++;
                end--;
            } else if (arr[start] + arr[end] < k ) {
                start++;
            } else if (arr[start] + arr[end] > k) {
                end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 8, 4, 5, 7, 6, 2, 1, 6};
        ArrayList<int[]> res = twoSumOnePass(arr, 12);
        System.out.print("[");
        for (int[] a : res) {
            System.out.print("(");
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print(")");
        }
        System.out.print("]");
    }
}
