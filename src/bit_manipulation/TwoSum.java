package bit_manipulation;

/**
 * Created by srinivas on 2/18/17.
 *
 * Two sum without any operator (no use of +, -, *, /)
 */
public class TwoSum {

    public static int twoSumWithoutOperator(int a, int b) {
        if(b== 0) {
            return a;
        }
        int xor = a ^ b;
        int and = (a & b) << 1;
        return twoSumWithoutOperator(xor, and);
    }

    public static void main(String[] args) {
        int a = 45;
        int b = 56;
        int res = twoSumWithoutOperator(a, b);
        System.out.println(res);
    }
}
