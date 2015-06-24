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

        System.out.println(mySqrtDouble(2.0)); // 1.4142112731933594
        System.out.println(mySqrtDouble(3.0)); // 1.7320489883422852
        System.out.println(mySqrtDouble(4.0)); // 2.0
        System.out.println(mySqrtDouble(5.0)); // 2.2360658645629883
        System.out.println(mySqrtDouble(16.0)); // 4.0
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

        //if we do not find exact sqrt value, we will return the approximated value with the defined precision
        return (high + low) / 2;
    }


    public static double mySqrtDouble(double x) {
        //firstly check if x is non-negative value
        if (x < 0) return -1;

        //also check if x==0 or x==1 because in these two cases sqrt(x) = x
        if (x == 0 || x == 1) return x;

        //now start the core part of the code
        double precision = 0.00001; //define the precision, so we stop when precision is achieved
        double low = 0;
        double high = x;

        //define a loop to continue if the precision has not yet achieved
        while (low + precision < high) {
            double mid = low + (high - low) / 2;
            if (mid == x / mid) {
                return mid; //we find the exact sqrt value!
            } else if (mid < x / mid) {
                low = mid; //we shift our focus to bigger half
            } else {
                high = mid; //shift focus to smaller half
            }
        }

        //if we do not find exact sqrt value, we will return the approximated value with the defined precision
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
//        //if we did not find exact sqrt value, we return the approximated value with the defined precision
//        return (high + low) / 2;
//    }


//    public static double sqrt(double a)
//    {
//        //firstly check if a is non-negative value
//        if(a<0) return -1;
//        //also check if a==0 or a==1 because in these two cases sqrt(a) = a
//        if(a==0 || a==1) return a;
//
//        //now start the core part of the code
//        double precision = 0.00001;//define the precision, so we stop when precision is achieved
//        double start = 0;
//        double end = a;
//        //we define these two start/end values because usually 0<sqrt(a)<a
//        //however, if a<1; then 0<a<sqrt(a)
//        if(a<1)
//            end = 1;
//
//        //define a loop to continue if the precision is not yet achieved
//        while(end-start>precision)
//        {
//            double mid = (start+end)/2;
//            double midSqr = mid*mid;
//            if(midSqr==a) return mid;//we find the exact sqrt value!
//            else if(midSqr<a) start = mid;//we shift our focus to bigger half
//            else end = mid;//shift focus to smaller half
//        }
//
//        //if we did not find exact sqrt value, we return the approximated value with the defined precision
//        return (start+end)/2;
//    }
}
