package dynamic_programming;

/**
 * Created by srinivas on 1/25/17.
 */
public class Knapsack01 {

    public static int knapsack(int[] wt, int[] val, int W) {
        int[][] k = new int[val.length+1][W+1];

        for(int i = 0; i< val.length; i++) {
            for(int j = 0; i< W; j++) {
                if(i == 0 || j == 0) {
                    k[i][j] = 0;
                    continue;
                }

                if(j - wt[i-1] >= 0) {
                    k[i][j] = Math.max(k[i-1][j], val[i-1] + k[i-1][j - wt[i-1]]);
                } else {
                    k[i][j] = k[i-1][j];
                }
            }
        }
        return k[val.length][W];
    }

    public static void main(String[] args) {
        int wt[] = {1, 3, 4, 5};
        int val[] = {1, 4, 5, 7};
        int W = 7;
        int totalValue = knapsack(wt, val, W);

        System.out.println("Max val: " + totalValue);
    }

}
