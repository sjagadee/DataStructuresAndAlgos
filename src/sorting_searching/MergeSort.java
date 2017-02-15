package sorting_searching;

/**
 * Created by srinivas on 2/15/17.
 *
 * implement merge sort
 */
public class MergeSort {

    public static void splitArray(int[] a, int first, int last, int[] res) {
        int mid = (first + last) /2;
        if(first<last) {
            splitArray(a, first, mid, res);
            splitArray(a, mid+1, last, res);
            merge(a, first, last, mid, res);
        }
    }

    private static void merge(int[] a, int first, int last, int mid, int[] res) {
        int s = first;
        int l = first;
        int r = mid+1;

        while(l <= mid && r <= last) {
            if(a[l] < a[r]) {
                res[s] = a[l];
                l++;
            } else {
                res[s] = a[r];
                r++;
            }
            s++;
        }
        while(l <= mid) {
            res[s] = a[l];
            s++;
            l++;
        }
        while (r <= last) {
            res[s] = a[r];
            s++;
            r++;
        }
        for(int i = first; i <= last; i ++) {
            a[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {10, 12, 4, 8, 15, 6, 2, 9, 11};
        int length = a.length;
        int[] result = new int[length];

        for(int i: a) {
            System.out.print(i + " ");
        }
        System.out.println();
        splitArray(a, 0, length-1, result);
        for(int i: result) {
            System.out.print(i + " ");
        }

    }
}
