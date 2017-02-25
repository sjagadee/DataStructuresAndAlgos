package string_arrays_matrix;

/**
 * Created by srinivas on 2/24/17.
 */
public class SqureSubMatrix {

    public static int maxSqureSubMatrix(int[][] arr) {
        int x = arr.length;
        if(x == 0) {
            return 0;
        }
        int y = arr[0].length;
        if(y == 0) {
            return 0;
        }
        int max = 0;
        int[][] size = new int[x][y];
        for(int i = 0; i< x; i++) {
            for(int j = 0; j < y; j++) {
                if(i == 0 || j == 0) {
                    size[i][j] = arr[i][j];
                } else if (arr[i][j] == 1) {
                    size[i][j] = Math.min(Math.min(size[i][j-1], size[i-1][j]), size[i-1][j-1]) + 1;
                }
                max = Math.max(max, size[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = { {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1} };
        int res = maxSqureSubMatrix(arr);
        System.out.println(res);
    }

}
