package IntervalAndMaintainStackForInterval.NeedToCheckIntervalOverlapping;

import LibraryOfLeetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 7/7/15.
 */
public class InsertInterval {
    public static void main(String[] args) {
        Interval first = new Interval(3, 5);
        Interval second = new Interval(6, 9);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(first);
        intervals.add(second);

        Interval newInterval = new Interval(2, 4);
        List<Interval> res = insert(intervals, newInterval);
        // 输入->[[3,5],[6,9]]和[2,4], 输出->[2,5],[6,9]
        for (Interval i : res) {
            System.out.print("[" + i.start + "," + i.end + "],");
        }
        System.out.println();

        ///////////////////////////////////////////////////////////////////////////
        Interval first2 = new Interval(5, 6);
        Interval second2 = new Interval(7, 9);
        ArrayList<Interval> intervals2 = new ArrayList<>();
        intervals2.add(first2);
        intervals2.add(second2);

        Interval newInterval2 = new Interval(2, 4);
        List<Interval> res2 = insert(intervals2, newInterval2);

        // 输入->[[5,6],[7,9]]和[2,4], 输出->[2,4],[5,6],[7,9]
        for (Interval i : res2) {
            System.out.print("[" + i.start + "," + i.end + "],");
        }
        System.out.println();
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval oldInterval : intervals) {
            if (newInterval.end < oldInterval.start) { // no overlapped case 1
                res.add(newInterval);
                newInterval = oldInterval;
            } else if (oldInterval.end < newInterval.start) { // no overlapped case 2
                res.add(oldInterval);
            } else { // overlapping case for else if (oldInterval.start <= newInterval.end || oldInterval.end >= newInterval.start)
                newInterval = new Interval(Math.min(oldInterval.start, newInterval.start), Math.max(oldInterval.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }
}
