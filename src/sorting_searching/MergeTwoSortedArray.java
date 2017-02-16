package sorting_searching;

/**
 * Created by srinivas on 2/15/17.
 * <p>
 * There is two ways to solve this problem
 */
public class MergeTwoSortedArray {

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];

        int s = 0;
        int l = 0;
        int r = 0;

        while (l < arr1.length && r < arr2.length) {
            if (arr1[l] <= arr2[r]) {
                temp[s] = arr1[l];
                l++;
            } else {
                temp[s] = arr2[r];
                r++;
            }
            s++;
        }
        while (l < arr1.length) {
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

    public static void mergeTwoArray(int[] arr1, int[] arr2, int sizeA, int sizeB) {

        int lastIndexOfA = sizeA - 1;
        int lastIndexOfB = sizeB - 1;
        int indexOfReturn = sizeA + sizeB - 1;
        while (lastIndexOfB >= 0) {
            if (lastIndexOfA >= 0 && arr1[lastIndexOfA] > arr2[lastIndexOfB]) {
                arr1[indexOfReturn] = arr1[lastIndexOfA];
                lastIndexOfA--;
            } else {
                arr1[indexOfReturn] = arr2[lastIndexOfB];
                lastIndexOfB--;
            }
            indexOfReturn--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 30, 40, 50};
        int[] arr2 = new int[]{12, 13, 23, 33, 55};
        int[] res = mergeSortedArray(arr1, arr2);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] a1 = new int[20];
        a1[0] = 10;
        a1[1] = 15;
        a1[2] = 20;
        a1[3] = 30;
        a1[4] = 35;

        int[] a2 = new int[]{12, 14, 17, 32};

        mergeTwoArray(a1, a2, 5, 4);

        for (int a : a1) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
