package Math.AppliedMath;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 6/30/15.
 */
public class MaxPointsOnALine {
    public static void main(String[] args) {
        Point[] test1 = {new Point(0, 0)};
        System.out.println(maxPoints(test1)); // 1
        Point[] test2 = {new Point(0, 0), new Point(1, 0)};
        System.out.println(maxPoints(test2)); // 2
        Point[] test3 = {new Point(0, 0), new Point(1, 1), new Point(1, -1)};
        System.out.println(maxPoints(test3)); // 2
        Point[] test4 = {new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)};
        System.out.println(maxPoints(test4)); // 5
        Point[] test5 = {new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        System.out.println(maxPoints(test5)); // 3
        Point[] test6 = {new Point(2, 3), new Point(3, 3), new Point(-5, 3), new Point(3, 3)};
        System.out.println(maxPoints(test6)); // 4
        Point[] test7 = {new Point(0, 0), new Point(1, 1), new Point(0, 0)};
        System.out.println(maxPoints(test7)); // 3
    }

    public static int maxPoints(Point[] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }
        int maxNumPoints = 1;
        Map<Double, Integer> map = new HashMap<>(); // new HashMap<slope, pointsCount>
        for (int i = 0; i < n; i++) {
            // shared point changed, map should be cleared and server the new point
            map = new HashMap<Double, Integer>();
            // maybe entire input are the same points,
            // so all same points's slope is represented by Integer.MIN_VALUE, the initial pointsCount is 1
            map.put((double) Integer.MIN_VALUE, 1);
            int duplicatePoints = 0;
            for (int j = i + 1; j < n; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) { // true if same Points
                    duplicatePoints++;
                } else {
                    double slope = 0.0;
                    if (points[j].x == points[i].x) { // true if vertical line
                        slope = Integer.MAX_VALUE;// vertical points slope is infinity
                    } else if (points[j].y == points[i].y) { // true if horizontal line
                        slope = 0.0;// horizontal points slope is 0.0
                    } else {
                        slope = ((double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x));
                    }
                    addPoint(map, slope);
                }
            }
            for (int notDuplicatePoints : map.values()) {
                maxNumPoints = Math.max(maxNumPoints, notDuplicatePoints + duplicatePoints);
            }
        }
        return maxNumPoints;
    }

    public static void addPoint(Map<Double, Integer> map, double slope) {
        if (!map.containsKey(slope)) {
            map.put(slope, 2);
        } else {
            map.put(slope, map.get(slope) + 1);
        }
    }
}
