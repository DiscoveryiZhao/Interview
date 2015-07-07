package Sorting.QuickSort;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindTheKclosestPointsToTheOriginIn2Dplane_Onlogn {
    public static Point[] closet(Point[] a, int k) {
        Comparator<Point> c = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                // a call of (p1.x * p1.x + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y) should return:
                // if((p1.x * p1.x + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y)) < 0) then p1 comes "before" p2 in the ordering, so p1 close to original than p2
                // if((p1.x * p1.x + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y)) > 0) then p1 comes "after" p2 in the ordering, so p2 close to original than p1
                // if((p1.x * p1.x + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y)) == 0) then p1 and p2 are considered "equal" in the ordering so p1 and p2 has same distance to original
                // Pythagorean theorem:
                // Since original is (0,0)
                // Point p1's x-axis distance to original is p1.x - 0
                // Point p1's y-axis distance to original is p1.y - 0
                // Point p1's distance to original is Math.sqrt(p1.x * p1.x + p1.y * p1.y)
                // Therefore, point p1's distance to original - point p2's distance to original
                return (int ) ((p1.x * p1.x + p1.y * p1.y ) - (p2.x * p2.x + p2.y * p2.y ));
            }
        };

        PriorityQueue<Point> minHeap = new PriorityQueue<>(k, c);
        for (Point p : a) {
            minHeap.add(p);
        }

        for (int i = 0; i < k; i++) {
            a[i] = minHeap.poll();
        }
        return Arrays.copyOfRange(a, 0, k);
    }
}
