package Sorting.HeapSort.BuildMaxHeadThenRemoveK;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yizhao on 7/7/15.
 */
public class FindtheKclosestPointsToTheOriginin2Dplane_Ologn {
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

    public static Point[] closestk(Point[] a, int k) {
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
                return (int) ((p1.x * p1.x + p1.y * p1.y) - (p2.x * p2.x + p2.y * p2.y));
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
