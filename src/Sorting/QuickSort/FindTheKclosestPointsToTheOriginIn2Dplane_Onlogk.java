package Sorting.QuickSort;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindTheKclosestPointsToTheOriginIn2Dplane_Onlogk {
    public static Point[] closestk(Point[] a, int k) {
        heapsort(a, k);
        return Arrays.copyOfRange(a, 0, k);
    }

    // O( nlogk)
    public static void heapsort(Point[] a, int k) {
        buildMaxHeap(a); // o(n)
        maintainMaxHeap(a, k);
    }

    // o(n)
    public static void buildMaxHeap(Point[] a) {
        int i = (a.length - 1) >> 1;
        while (i >= 0) {
            maintainMaxHeap(a, a.length, i);// O(logn)
            i--;
        }
    }

    public static void maintainMaxHeap(Point[] a, int k) {
        int i = k + 1;
        while (i >= 1) {
            swap(a, i, 0);
            maintainMaxHeap(a, i, 0);
            i--;
        }
    }

    // O( logn)
    public static void maintainMaxHeap(Point[] a, int heapSize, int i) {
        int l = (i << 1) + 1; // left node index for array index start from 0
        int r = (i << 1) + 2; // right node index for array index start from 0
        // Pythagorean theorem:
        // Since original is (0,0)
        // Point p1's x-axis distance to original is p1.x - 0
        // Point p1's y-axis distance to original is p1.y - 0
        // Point p1's distance to original is Math.sqrt(p1.x * p1.x + p1.y * p1.y)
        // Therefore, point p1's distance to original - point p2's distance to original
        int parentMax = i; // parent node index
        // a[parentMax] - a[l] < 0 then then a[l] comes "before" a[parentMax] in the ordering,
        if (l < heapSize && (a[parentMax].x * a[parentMax].x + a[parentMax].y * a[parentMax].y) - (a[l].x * a[l].x + a[l].y * a[l].y) < 0) {
            parentMax = l; // a[l] is larger than a[parentMax]
        }
        // a[parentMax] - a[l] < 0 then then a[l] comes "before" a[parentMax] in the ordering,
        if (r < heapSize && (a[parentMax].x * a[parentMax].x + a[parentMax].y * a[parentMax].y) - (a[r].x * a[r].x + a[r].y * a[r].y) < 0) {
            parentMax = r; // a[r] is larger than a[parentMax]
        }

        if (parentMax != i) {
            swap(a, parentMax, i);
            maintainMaxHeap(a, heapSize, parentMax);
        }
    }

    public static void swap(Point a[], int i, int j) {
        Point tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
