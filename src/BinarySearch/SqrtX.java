package BinarySearch;

/**
 * Created by yizhao on 6/21/15.
 */
public class SqrtX {
    public static void main(String[] args) {
        System. out.println(sqrt(1)); // 1
        System. out.println(sqrt(3)); // 1
        System. out.println(sqrt(4)); // 2
        System. out.println(sqrt(5)); // 2
        System. out.println(sqrt(9)); // 3
        System. out.println(sqrt(16)); // 4
        System. out.println(sqrt(2147483647)); // 46340
    }


    public static int sqrt(int x) {
        if (x < 2) {
            return x;
        } else {
            int low = 0;
            int high = x;
            while (low + 1 < high) {
                int mid = low + (high - low) / 2;
                if (mid <= x / mid) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
