package HashArrayTable.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 12/12/14.
 */
public class OddOccurrenceElements {
    public static void main(String[] args) {
        int[] a = { 2, 4, 5, 8, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        oddTimes(a); // [1, 3, 6, 7, 9]
    }

    public static void oddTimes(int[] a) {
        Set<Integer> hash = new HashSet<>();
        for (int i : a) {
            if (hash.contains(i)) {
                hash.remove(i);
            } else {
                hash.add(i);
            }
        }
        System.out.println(hash);
    }
}
