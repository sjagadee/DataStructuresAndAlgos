package string_arrays_matrix;

/**
 * Created by srinivas on 1/26/17.
 *
 * Search is done on row wise and column wise sorted matrix
 *
 */
public class SearchMatrix {

    public static Matrix search(int[][] a, int length, int searchVal) {
        int i = 0;
        int j = length-1;
        while (i < length && j >= 0) {
            if(a[i][j] == searchVal) {
                Matrix matrix  = new Matrix(i, j);
                return matrix;
            }
            // if the search element is less than that of current element move left
            if(a[i][j] > searchVal) {
                j--;
            }
            // if the search element is greater than that of current element move down
            else { // if(a[i][j] < searchVal )
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[][] a = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {19, 27, 39, 48},
                {22, 31, 43, 50} };

        Matrix matrix = search(a, a.length, 31);
        if(matrix != null) {
            System.out.println("row: " + matrix.row + " column: " + matrix.column);
        } else {
            System.out.println("Item not present in the matrix!");
        }
    }

    public static class Matrix {
        int row;
        int column;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}

