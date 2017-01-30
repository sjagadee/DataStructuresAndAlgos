package string_arrays_matrix;

/**
 * Created by srinivas on 1/25/17.
 *
 * Checking if the String has permutations of palindrome
 *
 * Example
 * input: Taco tac
 * output: true (as it has "Taco cat")
 *
 * input: amazing
 * output: false
 */
public class PermutationsOfPalindrome {

    /**
     * Firstly this method gets called from the main method
     *
     * This calls other methods such as
     * getFrequencyNumberOfEachCharInString which computes frequency number,
     * for each character in a given string_arrays_matrix
     *
     * Then calls isMaxOneOddNumberInTable which checks if the frequency table has
     * only one odd value (palindrome can have maximum only one odd value)
     *
     */
    public static boolean isPermutationsOfPalindrome(String str) {
        int[] table = getFrequencyNumberOfEachCharInString(str);
        return isMaxOneOddNumberInTable(table);
    }

    /**
     * This method checks if the table of frequency only one odd value,
     * otherwise returns false
     *
     */
    private static boolean isMaxOneOddNumberInTable(int[] table) {
        boolean check = false;
        for(int val: table) {
            if(val % 2 == 1) {
                if(check) {
                    return false;
                }
                check = true;
            }
        }
        return true;
    }

    /**
     * This method calculates frequency of each character in the string_arrays_matrix and adds it to the frequency table
     *
     */
    private static int[] getFrequencyNumberOfEachCharInString(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for(char c: str.toCharArray()) {
            int val = getCharNumber(c);
            if (val != -1) {
                table[val] += 1;
            }
        }
        return table;
    }

    /**
     * This method returns the char number of each value
     * Example a -> 0, b -> 1, c -> 3 and so on..
     * returns -1 if not a char (a-z or A-z)
     *
     */
    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(c);

        if(a <= val && val <= z) {
            return val-a;
        }

        if(A <= val && val <= Z) {
            return val-A;
        }
        return -1;
    }


    public static void main(String[] args) {
        String str = "tato Cac";
        boolean solution = isPermutationsOfPalindrome(str);
        if (solution) {
            System.out.println("String " + str + " has permutations of palindrome for the string_arrays_matrix");
        } else {
            System.out.println("String " + str + " does not have permutations of palindrome for the string_arrays_matrix");
        }
    }
}
