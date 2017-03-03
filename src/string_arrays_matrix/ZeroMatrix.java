package string_arrays_matrix;

import java.util.ArrayList;

/**
 * Created by srinivas on 1/27/17.
 * <p>
 * This problem specifies that if we find any 0 element in the matrix,
 * then we set its row and column with zero element (if we have only one zero in the matrix)
 * <p>
 * Then a new problem can be asked if there are many zeros in the matrix
 */
public class ZeroMatrix {

    private static void setZeroToRowAndColumn(int[][] a) {
        int nullRow = -1;
        int nullColumn = -1;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    nullRow = i;
                    nullColumn = j;
                }
            }
        }

        if (nullRow != -1 && nullColumn != -1) {
            for (int i = 0; i < a[0].length; i++) {
                a[nullRow][i] = 0;
            }
            for (int i = 0; i < a.length; i++) {
                a[i][nullColumn] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {10, 20, 30, 40},
                {15, 25, 0, 45},
                {19, 27, 39, 48}};

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");

        setZeroToRowAndColumn(a);


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }


        int[][] b = {
                {10, 20, 3, 40},
                {15, 0, 49, 45},
                {19, 27, 39, 0}};

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n");

        setZeroToMatrix(b);


        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Zero {
        int zeroRow;
        int zeroCol;

        public Zero(int zeroRow, int zeroCol) {
            this.zeroCol = zeroCol;
            this.zeroRow = zeroRow;
        }
    }

    // Multiple zeros Matrix
    private static void setZeroToMatrix(int[][] a) {
        ArrayList<Zero> newList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    newList.add(new Zero(i, j));
                }
            }
        }

        for (Zero z : newList) {
            for (int i = 0; i < a[0].length; i++) {
                a[z.zeroRow][i] = 0;
            }
            for (int i = 0; i < a.length; i++) {
                a[i][z.zeroCol] = 0;
            }
        }
    }

}
