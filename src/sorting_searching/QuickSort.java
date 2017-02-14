package sorting_searching;

/**
 * Created by srinivas on 2/13/17.
 *
 * Quick sort is a divide and conquer algorithm
 * which is implemented recursively
 * it is an in place algorithm (hence the space complexity is O(1))
 *
 * Time complexity is O(n logn) (Average and best case)
 * O(n^2) in worst case
 */
public class QuickSort {

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length -1);
    }

    private static void quickSort (int[] a, int start, int end) {
           int pivot = (start + end) / 2;
           int index = partition(a, start, end, pivot);
           if(start < index-1) {
               quickSort(a, start, index - 1);
           }
           if(end > index) {
               quickSort(a, index, end);
           }
    }

    private static int partition(int[] a, int start, int end, int pivot) {
        while(start <= end) {
            while(a[start] <= a[pivot]) {
                start++;
            }
            while (a[end] > a[pivot]) {
                end--;
            }
            if(start <= end) {
                swap(a, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap (int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[] {4, 2, 1, 6, 7, 3, 11, 0};
        System.out.print("Before Quick Sort: ");
        for(int k: a) {
            System.out.print(k + " ");
        }
        quickSort(a);
        System.out.println();
        System.out.print("After Quick Sort: ");
        for(int k: a) {
            System.out.print(k + " ");
        }
    }
}
