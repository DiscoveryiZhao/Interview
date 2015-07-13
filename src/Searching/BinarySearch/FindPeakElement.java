package Searching.BinarySearch;

/**
 * Created by yizhao on 7/13/15.
 */
public class FindPeakElement {
    public int findPeakElement(int[] a) {
        int low = 0;
        int high = a.length - 1 ;
        while (low + 1 < high) {
            // Invariant: a[low] <= a[mid+1] < a[high]
            int mid = low + (high - low) / 2;
            if (a[mid] > a[mid + 1]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if(a[low] > a[high]){
            return low;
        }

        return high;
    }
}
