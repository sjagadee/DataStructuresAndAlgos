package sorting_searching;

/**
 * Created by srinivas on 2/15/17.
 *
 * There is two ways to solve this problem
 */
public class MergeTwoSortedArray {

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];

        int s = 0;
        int l = 0;
        int r = 0;

        while(l < arr1.length && r < arr2.length) {
            if(arr1[l] <= arr2[r]) {
                temp[s] = arr1[l];
                l++;
            } else {
                temp[s] = arr2[r];
                r++;
            }
            s++;
        }
        while(l < arr1.length) {
            temp[s] = arr1[l];
            l++;
            s++;
        }
        while (r < arr2.length) {
            temp[s] = arr2[r];
            r++;
            s++;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {10, 30, 40, 50};
        int[] arr2 = new int[] {12, 13, 23, 33, 55};

        int[] res = mergeSortedArray(arr1, arr2);
        for(int i: res) {
            System.out.print(i + " ");
        }

    }
}
