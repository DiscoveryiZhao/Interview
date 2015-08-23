package Math.Other;

import java.util.HashSet;
import java.util.Set;

/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(0)); // true
        System.out.println(isHappy(1)); // true
        System.out.println(isHappy(2)); // false
        System.out.println(isHappy(3)); // false
        System.out.println(isHappy(4)); // false
        System.out.println(isHappy(5)); // false
        System.out.println(isHappy(6)); // false
        System.out.println(isHappy(7)); // true
        System.out.println(isHappy(8)); // false
        System.out.println(isHappy(9)); // false
        System.out.println(isHappy(10)); // true
        System.out.println(isHappy(11)); // false
        System.out.println(isHappy(12)); // false
        System.out.println(isHappy(13)); // true
        System.out.println(isHappy(14)); // false
        System.out.println(isHappy(15)); // false
        System.out.println(isHappy(16)); // false
        System.out.println(isHappy(17)); // false
        System.out.println(isHappy(18)); // false
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(20)); // false
    }

    public static boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<>();
        while (n != 1) {
            if (hash.contains(n)) {
                return false;
            }
            hash.add(n);
            n = getNextHappy(n);
        }
        return true;
    }

    private static int getNextHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10); // % 10 -> get the last digit of n
            n /= 10;
        }
        return sum;
    }



//    // 还有用O(1)空间的，就像链表找有没有圈一样，用快慢指针的思路。
//    public static boolean isHappy(int n) {
//        int x = n;
//        int y = n;
//        while (x > 1) {
//            x = cal(x);
//            if (x == 1) return true;
//            y = cal(cal(y));
//            if (y == 1) return true;
//
//            if (x == y) return false;
//        }
//        return true;
//    }
//
//    public static int cal(int n) {
//        int x = n;
//        int s = 0;
//        while (x > 0) {
//            s = s + (x % 10) * (x % 10);
//            x = x / 10;
//        }
//        return s;
//    }
}
