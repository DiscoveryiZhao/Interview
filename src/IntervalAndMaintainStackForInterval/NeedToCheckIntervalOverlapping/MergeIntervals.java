package IntervalAndMaintainStackForInterval.NeedToCheckIntervalOverlapping;

import LibraryOfLeetcode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yizhao on 7/7/15.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        // [2,3],[5,5],[2,2],[3,4],[3,4]
        Interval zeroIntervals1 = new Interval(2, 3);
        Interval zeroIntervals2 = new Interval(5, 5);
        Interval zeroIntervals3 = new Interval(2, 2);
        Interval zeroIntervals4 = new Interval(3, 4);
        Interval zeroIntervals5 = new Interval(3, 4);
        ArrayList<Interval> zeroIntervals = new ArrayList<Interval>();
        zeroIntervals.add(zeroIntervals1);
        zeroIntervals.add(zeroIntervals2);
        zeroIntervals.add(zeroIntervals3);
        zeroIntervals.add(zeroIntervals4);
        zeroIntervals.add(zeroIntervals5);
        List<Interval> result0 = merge(zeroIntervals);
        // 输入-> [[2,3],[5,5],[2,2],[3,4],[3,4]], 输出->[[2,4],[5,5]]
        for (Interval i : result0) {
            System.out.print("[" + i.start + "," + i.end + "]" + ",");
        }
        System.out.println();

        // //////////////////////////////////////////////////////////////////////////////////

        // [1,3],[2,6],[8,10],[15,18]
        Interval firstIntervals1 = new Interval(1, 3);
        Interval firstIntervals2 = new Interval(2, 6);
        Interval firstIntervals3 = new Interval(8, 10);
        Interval firstIntervals4 = new Interval(15, 18);
        ArrayList<Interval> firstIntervals = new ArrayList<Interval>();
        firstIntervals.add(firstIntervals1);
        firstIntervals.add(firstIntervals2);
        firstIntervals.add(firstIntervals3);
        firstIntervals.add(firstIntervals4);

        List<Interval> result1 = merge(firstIntervals);
        // 输入-> [1,3],[2,6],[8,10],[15,18], 输出->[1,6],[8,10],[15,18]
        for (Interval i : result1) {
            System.out.print("[" + i.start + "," + i.end + "]" + ",");
        }
        System.out.println();

        // //////////////////////////////////////////////////////////////////////////////////

        // [1,3],[2,4]
        Interval secondIntervals1 = new Interval(1, 3);
        Interval secondIntervals2 = new Interval(2, 4);
        ArrayList<Interval> secondIntervals = new ArrayList<Interval>();
        secondIntervals.add(secondIntervals1);
        secondIntervals.add(secondIntervals2);

        List<Interval> result2 = merge(secondIntervals);
        // 输入-> [1,3],[2,4], 输出->[1,4]
        for (Interval i : result2) {
            System.out.print("[" + i.start + "," + i.end + "]" + ",");
        }
        System.out.println();

        // //////////////////////////////////////////////////////////////////////////////////

        // [1,2],[3,4]
        Interval thirdIntervals1 = new Interval(1, 2);
        Interval thirdIntervals2 = new Interval(3, 4);
        ArrayList<Interval> thirdIntervals = new ArrayList<Interval>();
        thirdIntervals.add(thirdIntervals1);
        thirdIntervals.add(thirdIntervals2);

        List<Interval> result3 = merge(thirdIntervals);
        // 输入-> [1,2],[3,4], 输出->[1,2],[3,4]
        for (Interval i : result3) {
            System.out.print("[" + i.start + "," + i.end + "]" + ",");
        }
        System.out.println();

        // //////////////////////////////////////////////////////////////////////////////////

        // [3,4],[1,2]
        Interval fourthIntervals1 = new Interval(3, 4);
        Interval fourthIntervals2 = new Interval(1, 2);
        List<Interval> fourthIntervals = new ArrayList<>();
        fourthIntervals.add(fourthIntervals1);
        fourthIntervals.add(fourthIntervals2);

        List<Interval> result4 = merge(fourthIntervals);
        // 输入-> [3,4],[1,2], 输出->[1,2],[3,4]
        for (Interval i : result4) {
            System.out.print("[" + i.start + "," + i.end + "]" + ",");
        }
        System.out.println();

        // //////////////////////////////////////////////////////////////////////////////////

        // [2,4],[1,3]
        Interval fifthIntervals1 = new Interval(2, 4);
        Interval fifthIntervals2 = new Interval(1, 3);
        List<Interval> fifthIntervals = new ArrayList<>();
        fifthIntervals.add(fifthIntervals1);
        fifthIntervals.add(fifthIntervals2);

        List<Interval> result5 = merge(fifthIntervals);
        // 输入-> [2,4],[1,3], 输出->[1,4]
        for (Interval i : result5) {
            System.out.print("[" + i.start + "," + i.end + "]" + ",");
        }
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> intervals) {
        // sort the intervals based on start points
        Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        Collections.sort(intervals, comparator);
        return mergeIntervals(intervals);
    }

    private static List<Interval> mergeIntervals(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        int L = 0;
        int R = 1;
        while (R < n) {
            // intervals[left] 为真集合， 而不是intervals[0..left], intervals.get(left).end < intervals.get(right).start
            if (intervals.get(L).end < intervals.get(R).start) {
                res.add(intervals.get(L));
                L = R;
            } else {
                // merged case
                intervals.get(L).end = Math.max(intervals.get(L).end, intervals.get(R).end);
            }
            R++;
        }

        res.add(intervals.get(L));
        return res;
    }
}
