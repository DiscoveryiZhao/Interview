package Sorting.QuickSort;

import java.awt.*;
import java.util.Arrays;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindTheKclosestPointsToTheOriginIn2Dplane_On {
    public static void main(String[] args) {
        Point[] test1 = {new Point(16, -17), new Point(3, 21), new Point(1, -1), new Point(3, -4), new Point(8, -9), new Point(2, -3)};
        Point[] res = closestk(test1, 4);
        for (Point p : res) {
            System.out.println("p.x:" + p.x + "  ,p.y:" + p.y);
        }
        // output:
        // p.x:1.0 ,p.y:-1.0
        // p.x:2.0 ,p.y:-3.0
        // p.x:3.0 ,p.y:-4.0
        // p.x:8.0 ,p.y:-9.0
    }

    public static Point[] closestk(Point[] p, int k) {
        return conquer(p, 0, p.length - 1, k - 1);
    }

    public static Point[] conquer(Point[] p, int low, int high, int k) {
        while (low <= high) {
            int q = partition(p, low, high);
            if (q == k) {
                return Arrays.copyOfRange(p, 0, k + 1);
            } else if (q < k) {
                low = q + 1;
            } else { // q > k
                high = q - 1;
            }
        }
        return null;
    }

    // partition的重点思想概念为，在每此partition过后，p[pivot]左边的数必须小于a[pivot],右边的数必须都大于a[pivot]。
    public static int partition(Point[] p, int low, int high) {
        swap(p, low + (int) Math.random() * (high - low + 1), high);
        double pivot = Math.sqrt(p[high].x * p[high].x + p[high].y * p[high].y);
        int L = low - 1;
        int R = low;
        while (R < high) {
            // p[0..left] <= pivot
            if (Math.sqrt(p[R].x * p[R].x + p[R].y * p[R].y) <= pivot) {
                L++;
                swap(p, L, R);
            }
            R++;
        }
        L++;
        swap(p, L, high);
        return L;
    }

    public static void swap(Point[] p, int i, int j) {
        Point tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }

}
