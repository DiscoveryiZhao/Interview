package BinarySearch;

/**
 * Created by yizhao on 5/17/15.
 */
public class BinarySearch {
    public int binarySearch(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        int mid;

    /*[1, 2]*/
        // 这里为了避免死循环我们用start + 1 < end
        // 如果用start + 1 < end，当循环结束的时候，可能start和end是相邻的，这个时候我们需要去做一个补充的判断，就是start和end是不是答案
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                // 我们不用start=mid+1这种模板英文，mid+1的模板不能套用所有binary search的算法题目，自己容易搞混掉，所以我们就用start=mid这种模板来套所有的算法题
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A[low] == target) {
            return low;
        }

        if (A[high] == target) {
            return high;
        }

        return -1;

    }
}
