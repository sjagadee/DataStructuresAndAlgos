package dynamic_programming;

/**
 * Created by srinivas on 3/3/17.
 * Maximum sub array EG:
 * {2, -4, 3, 6, -2, 5, -8}
 * => 12
 */
public class MaximumSubArray {

    // This solution would be done in O(n^2) time
    public static int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length; i++) {
            int cur = 0;
            for(int j = i; j < arr.length; j++) {
                cur += arr[j];
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static int maxSubArrayDy(int[] arr) {
        int max_cur = arr[0];
        int max_global = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max_cur = Math. max(arr[i], arr[i] + max_cur);
            max_global = Math.max(max_cur, max_global);
        }
        return max_global;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 8, -3, 6, -15};
        int res = maxSubArrayDy(arr);
        System.out.print(res);
    }
}
