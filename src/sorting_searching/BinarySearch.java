package sorting_searching;

/**
 * Created by srinivas on 2/15/17.
 *
 * two ways to implement binary search
 * 1. recursive
 * 2. iterative
 */
public class BinarySearch {

    public static int binarySearchRecursive(int[] array, int start, int end, int searchVal) {

        int mid = (start+ end) /2;
        if(array[mid] == searchVal) {
            return mid;
        } else if(array[mid] > searchVal) {
            return binarySearchRecursive(array, start, mid-1, searchVal);
        } else if(array[mid] < searchVal) {
            return binarySearchRecursive(array, mid+1, end, searchVal);
        } else {
            return -1;
        }
    }

    public static int binarySearch(int[] array, int start, int end, int searchVal) {

        int mid;
        while(start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == searchVal) {
                return mid;
            } else if (array[mid] > searchVal) {
                end = mid-1;
            } else if (array[mid] < searchVal) {
                start = mid+1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int[] array = new int[] {1,3,5,6,7,9,11,14,16};
        int index = binarySearch(array, 0, array.length -1, 1);
        if(index != -1) {
            System.out.print("Value found at " + index);
        } else {
            System.out.print("Value not found");
        }
    }
}
