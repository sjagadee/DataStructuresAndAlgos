package bit_manipulation;

/**
 * Created by srinivas on 2/21/17.
 *
 * We need to rotate int a into N times
 */
public class RotateBits {

    public static int rotateBits(int a, int N) {
        return (a >> N | a << (Integer.SIZE - N));
    }

    public static void main(String[] args) {
        int res = rotateBits(8, 3);
        System.out.println(8 + " => " + res);
        System.out.println(Integer.toBinaryString(8) + " => " + Integer.toBinaryString(res));
    }
}
