package string_arrays_matrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srinivas on 2/13/17.
 */
public class ThreeSum {

    private static ArrayList<int[]> threeSum(int[] array) {
        ArrayList<int[]> list = new ArrayList<>();
        int start;
        int end;
        Arrays.sort(array);

        for (int i = 0; i < array.length - 3; i++) {
            if (i == 0 || array[i] > array[i - 1]) {
                start = i + 1;
                end = array.length - 1;
                while (start < end) {
                    if (array[i] + array[start] + array[end] == 0) {
                        list.add(new int[]{array[i], array[start], array[end]});
                    }
                    if (array[i] + array[start] + array[end] < 0) {
                        int currentStart = start;
                        while (array[start] == array[currentStart] && start < end) {
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while (array[end] == array[currentEnd] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, -1, -4, -1, 2};
        ArrayList<int[]> res = threeSum(array);
        for (int[] a : res) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
