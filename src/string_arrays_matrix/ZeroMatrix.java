package string_arrays_matrix;

/**
 * Created by srinivas on 1/27/17.
 *
 * This problem specifies that if we find any 0 element in the matrix then we set its row and column with zero element
 */
public class ZeroMatrix {

    private static void setZeroToRowAndColumn(int[][] a) {
        int nullRow = -1;
        int nullColumn = -1;

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 0) {
                    nullRow = i;
                    nullColumn = j;
                }
            }
        }

        if(nullRow != -1 && nullColumn != -1) {
            for(int i = 0; i < a[0].length; i++) {
                a[nullRow][i] = 0;
            }
            for(int i =0; i < a.length; i++) {
                a[i][nullColumn] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {10, 20, 30, 40},
                {15, 25, 0, 45},
                {19, 27, 39, 48}};

        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j< a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");

        setZeroToRowAndColumn(a);


        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j< a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

}
