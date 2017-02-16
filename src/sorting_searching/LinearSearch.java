package sorting_searching;

/**
 * Created by srinivas on 2/15/17.
 *
 * Linear search
 */
public class LinearSearch {

    public static int linearSearch(int[] array, int searchEle){
        for (int i =0; i< array.length; i ++) {
            if(array[i] == searchEle) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 14, 5, 17, 8, 19, 2, 24, 26, 20, 9};
        int index = linearSearch(array, 20);
        if(index != -1) {
            System.out.print("Value found at " + index);
        } else {
            System.out.print("Value not found");
        }

    }
}
