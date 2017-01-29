package miscellaneous;

/**
 * Created by srinivas on 1/28/17.
 *
 * Checks isPrime in O(Sqrt(n)) time complexity
 */
public class CheckIfPrime {
    public static void main(String[] args) {
        int number = 837;
        boolean result = isPrime(number);
        if(result) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static boolean isPrime(int number) {
        if(number == 1) {
            return false;
        }
        if(number == 2 || number == 3) {
            return true;
        }
        if(number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) +1;
        for(int i =3; i< sqrt; i+=2){
            if(number%sqrt == 0) {
                return false;
            }
        }
        return true;
    }

}
