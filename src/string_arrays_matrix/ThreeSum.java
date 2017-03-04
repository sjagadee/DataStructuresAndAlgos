package string_arrays_matrix;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srinivas on 2/13/17.
 *
 * this is a kind of a problem which actually takes in 3 numbers in the array and
 * would sum up to be 0
 *
 * ex {-2 -1, 3} = 0
 * {9, -8, -1} = 0
 */
public class ThreeSum {

    // this would take O(n^3) time complexity
    private static ArrayList<int[]> threeSumBruteForce(int[] arr) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length -3; i++) {
            if(i ==0 || arr[i-1] < arr[i]) {
                for (int j = i+1; j < arr.length -1; j++) {
                    if(j == i+1 || arr[j-1] < arr[j]) {
                        for (int k = j+1; k < arr.length; k++) {
                            if(k == j+1 || arr[k-1] < arr[k]) {
                                if(arr[i] + arr[j] + arr[k] == 0) {
                                    list.add(new int[]{arr[i], arr[j], arr[k]});
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    // this solution runs in O(n^2) time complexity  - hence an efficient solution
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
            for (int i : a) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
