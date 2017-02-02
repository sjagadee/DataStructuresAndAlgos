package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by srinivas on 2/1/17.
 */
public class CoinChangeProblem {

    private static Map<String, Integer> memo = new HashMap<>();

    private static int coinChangeRecursive(int amtLeft, int[] dinominations) {
        return coinChangeRecursive(amtLeft, dinominations, 0);
    }

    private static int coinChangeRecursive(int amtLeft, int[] dinominations, int index) {

        String memoKey = amtLeft + " " + index;

        if(memo.containsKey(memoKey)) {
            System.out.println("Grabbing [" + memoKey + "]");
            return memo.get(memoKey);
        }

        // base cass
        if(amtLeft == 0) return 1;

        if(amtLeft < 0) return 0;

        if(dinominations.length == index) return 0;

        System.out.println("For " + amtLeft + " dinominations are "
                + Arrays.toString(Arrays.copyOfRange(dinominations, index, dinominations.length)));

        int currentCoin = dinominations[index];

        int currentCount = 0;

        while(amtLeft >=0) {
            currentCount += coinChangeRecursive(amtLeft, dinominations, index+1);
            amtLeft -= currentCoin;
        }

        memo.put(memoKey, currentCount);
        return currentCount;
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] dinominations = new int[]{1,2, 3, 4};
        int result = coinChangeRecursive(amount, dinominations);

        System.out.print(result);
    }
}
