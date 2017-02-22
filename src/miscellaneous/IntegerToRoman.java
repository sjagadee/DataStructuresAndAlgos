package miscellaneous;

/**
 * Created by srinivas on 2/22/17.
 *
 * This problem would change the given integer into roman numbers
 */
public class IntegerToRoman {
    private static final String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L",
            "XL", "X", "IX", "V", "IV", "I"};

    private static final int[] numValues = new int[]{1000, 900, 500, 400, 100, 90, 50,
            40, 10, 9, 5, 4, 1};

    public static String integerToRoman(int number) {
        if(number > 3999 && number <= 0) {
        }

        int count = 0;
        StringBuilder str = new StringBuilder();
        while (number > 0) {
            if(number - numValues[count] >=0) {
                str.append(roman[count]);
                number -= numValues[count];
            } else {
                count++;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int val = 278;
        String res = integerToRoman(val);
        System.out.println(res);
    }

}
