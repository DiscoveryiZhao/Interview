package BinarySearch;

/**
 * Created by yizhao on 6/21/15.
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(1)); // 1
        System.out.println(mySqrt(3)); // 1
        System.out.println(mySqrt(4)); // 2
        System.out.println(mySqrt(5)); // 2
        System.out.println(mySqrt(9)); // 3
        System.out.println(mySqrt(16)); // 4
        System.out.println(mySqrt(2147483647)); // 46340
    }


    /*Reference: https://www.youtube.com/watch?v=XvsQ68jUc2U*/
    public static int mySqrt(int x) {
        //firstly check if x is non-negative value
        if (x < 0) return -1;

        //also check if x==0 or x==1 because in these two cases sqrt(x) = x
        if (x == 0 || x == 1) return x;

        //now start the core part of the code
        int precision = 1; //define the precision, so we stop when precision is achieved
        int low = 0;
        int high = x;

        //define a loop to continue if the precision has not yet achieved
        while (low + precision < high) {
            int mid = low + (high - low) / 2;
            if (mid == x / mid) {
                return mid; //we find the exact sqrt value!
            } else if (mid < x / mid) {
                low = mid; //we shift our focus to bigger half
            } else {
                high = mid; //shift focus to smaller half
            }
        }

        //if we do not find exact sqrt value, we will return the approxiated value with the defined precision
        return (high + low) / 2;
    }


//    /*Reference: https://www.youtube.com/watch?v=XvsQ68jUc2U*/
//    public static int mySqrt(int x) {
//        //firstly check if x is non-negative value
//        if (x < 0) return -1;
//
//        //also check if x==0 or x==1 because in these two cases sqrt(x) = x
//        if (x == 0 || x == 1) return x;
//
//        //now start the core part of the code
//        int precision = 1; //define the precision, so we stop when precision is achieved
//        int low = 0;
//        int high = x;
//
//        //we define these two low/high values because usually 0<sqrt(x)<x
//        //however, if x<1; then 0<x<sqrt(x)
//        if (x < 1) {
//            high = 1;
//        }
//
//        //define a loop to continue if the precision is not yet achieved
//        while (low + precision < high) {
//            int mid = low + (high - low) / 2;
//            int midSqr = mid;
//            if (midSqr == x / mid) {
//                return mid; //we find the exact sqrt value!
//            } else if (midSqr < x / mid) {
//                low = mid; //we shift our focus to bigger half
//            } else {
//                high = mid; //shift focus to smaller half
//            }
//        }
//
//        //if we did not find exact sqrt value, we return the approxiated value with the defined precision
//        return (high + low) / 2;
//    }


//    public static int mySqrt(int x) {
//        if (x == 0 || x == 1) return x;
//
//
//        int low = 0;
//        int high = x;
//        while (low + 1 < high) {
//            int mid = low + (high - low) / 2;
//            int midSqr = mid*mid;
//            if(midSqr == x) return mid;
//            else if(midSqr < x) low = mid;
//            else high = mid;
//        }
//        return (high + low) / 2;
//    }
}
