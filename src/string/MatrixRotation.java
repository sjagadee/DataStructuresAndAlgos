package string;

/**
 * Created by srinivas on 1/26/17.
 *
 * Matrix rotation (anti-clockwise and clockwise) in-place
 *
 * Example:
 *
 * Original
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * After anti-clockwise rotation
 *
 * 3 6 9
 * 2 5 8
 * 1 4 7
 *
 * After clockwise rotation
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 */
public class MatrixRotation {

    public static void main(String[] args) {

        // This is a 2D array which represents the 4X4 matrix
        int[][] a =  { {10, 11, 12, 13}, {14, 15, 16, 17}, {18, 19, 20, 21}, {22, 23, 24, 25}};

        // Print original string
        System.out.println("Original Matrix: \n");
        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j< a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        // Anti-clockwise rotation
        rotateAntiClockwise(a, a.length);
        System.out.println("\nMatrix after anti-clockwise rotation: \n");
        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j< a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        // Clockwise rotation
        rotateClockwise(a, a.length);
        System.out.println("\nMatrix after clockwise rotation: \n");
        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j< a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * This method would rotate the matrix in clockwise direction
     *
     * We are not returning anything because this is a in-place solution
     */
    private static void rotateClockwise(int[][] a, int n) {

        for(int i = 0; i < n/2; i++) {
            for(int j = i; j< n-1-i; j++) {
                int first = n-1-i;
                int last = n-1-j;

                int temp = a[i][j];
                a[i][j] = a[last][i];
                a[last][i] = a[first][last];
                a[first][last] = a[j][first];
                a[j][first] = temp;
            }
        }
    }

    /**
     *
     * This method would rotate the matrix in anti-clockwise direction
     *
     * We are not returning anything because this is a in-place solution
     *
     */
    private static void rotateAntiClockwise(int[][] a, int n) {

        for(int i = 0; i < n/2; i++) {
            for(int j = i; j< n-1-i; j++) {
                int first = n-1-i;
                int last = n-1-j;

                int temp = a[i][j];
                a[i][j] = a[j][first];
                a[j][first] = a[first][last];
                a[first][last] = a[last][i];
                a[last][i] = temp;
            }
        }
    }
}
