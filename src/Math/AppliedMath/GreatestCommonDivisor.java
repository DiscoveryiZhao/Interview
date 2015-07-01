package Math.AppliedMath;

/**
 * Created by yizhao on 6/30/15.
 */
public class GreatestCommonDivisor {
    public static void main(String[] args){

        System. out.println(gcdRecursion(12,8)); // 4

        System. out.println(gcdIterator(12,8)); // 4

    }

    public static int gcdRecursion(int a, int b) {

        if (a == 0 || b == 0) {

            return a + b; // base case

        } else {

            return gcdRecursion(b, a % b);

        }

    }

    public static int gcdIterator(int a, int b) {

        // until either one of them is 0

        while (a != 0 && b != 0) {

            int c = b;

            b = a % b;

            a = c;

        }

        return a + b; // either one is 0, so return the non-zero value

    }
}
