package string_and_matrix;

/**
 * Created by srinivas on 1/27/17.
 */
public class SprialOrderMatrixPrint {

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
                dir = 1;
            }else if(dir == 1) {
                for(int i =top; i <= bottom; i++) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
                dir = 2;
            } else if(dir == 2 ) {
                for(int i = right; i >= left; i--) {
                    System.out.print(a[bottom][i] + " ");
                }
                bottom--;
                dir = 3;
            } else  if(dir == 3) {
                for(int i = bottom; i >= top; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
                dir = 0;
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
