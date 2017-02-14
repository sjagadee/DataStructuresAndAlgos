package string_arrays_matrix;

import java.util.ArrayList;

/**
 * Created by srinivas on 2/13/17.
 *
 * Integer permutations and String Permutations
 */
public class Permutations {

    public static ArrayList<int[]> permutationsOfIntegers(int[] array) {
        ArrayList<int[]> results = new ArrayList<>();
        permutationsOfIntegers(array, 0, results);
        return results;
    }


    public static void permutationsOfIntegers(int[] array, int start, ArrayList<int[]> results) {
        if(start >= array.length) {
            results.add(array.clone());
        } else {
            for(int i = start; i< array.length; i++) {
                swap(array, start, i);
                permutationsOfIntegers(array, start+1, results);
                swap(array, start, i);
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static ArrayList<String> permutationsOfString(String s) {
        ArrayList<String> results = new ArrayList<>();
        permutationsOfString("", s, results);
        return results;
    }

    private static void permutationsOfString(String prefix, String suffix, ArrayList<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permutationsOfString(prefix + suffix.charAt(i), suffix.substring(0, i)
                        + suffix.substring(i + 1, suffix.length()), results);
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        ArrayList<String> results = permutationsOfString(s);

        for(String a: results) {
            System.out.println(a);
        }

        int[] array = new int[] {1, 2, 3};
        ArrayList<int[]> result = permutationsOfIntegers(array);

        for (int[] a: result) {
            for(int i = 0; i< a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

    }
}
