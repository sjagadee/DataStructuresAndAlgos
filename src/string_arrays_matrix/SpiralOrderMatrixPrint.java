package string_arrays_matrix;

/**
 * Created by srinivas on 1/27/17.
 *
 * This would print the matrix in spiral order
 *
 * eg:
 * 11 12 13 14
 * 15 16 17 18
 * 19 20 21 22
 *
 * is printed in
 * 11 12 13 14 18 22 21 20 19 15 16 17
 *
 */
public class SpiralOrderMatrixPrint {

    public static void printMatrix(int[][] a, int col, int row) {
        int top = 0;
        int bottom = row-1;
        int left  = 0;
        int right = col-1;
        int dir = 0;

        while(top <= bottom && left <= right) {
            if(dir == 0) {
                for(int i =left; i <= right; i++) {
                    System.out.print(a[top][i] + " ");
                }
                top++;
            }else if(dir == 1) {
                for(int i =top; i <= bottom; i++) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
            } else if(dir == 2 ) {
                for(int i = right; i >= left; i--) {
                    System.out.print(a[bottom][i] + " ");
                }
                bottom--;
            } else  if(dir == 3) {
                for(int i = bottom; i >= top; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
    }

    public  static void main(String[] args) {
        int[][] a = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {19, 27, 39, 48}};

        printMatrix(a, a[0].length, a.length);
    }

}
