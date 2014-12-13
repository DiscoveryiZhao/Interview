package HashArrayTable.HashSet;

import java.util.HashSet;

/**
 * Created by yizhao on 12/12/14.
 */
public class OddOccurrenceElements {
    public static void main(String[] args) {
        int[] a = { 2, 4, 5, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        oddTimes(a); // [1, 3, 6, 7, 9]
    }

    public static void oddTimes(int[] a) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : a) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                set.remove(i);
            }
        }
        System.out.println(set);
    }
}
