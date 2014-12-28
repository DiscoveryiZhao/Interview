package HashArrayTable.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 12/12/14.
 */
public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        System.out.println(removeDuplicatesHashSet("bananas")); // bans
        System.out.println(removeDuplicatesHashSet("aabbccdefatafaz")); // abcdeftz
        System.out.println(removeDuplicatesBooleanHash("bananas")); // bans
        System.out.println(removeDuplicatesBooleanHash("aabbccdefatafaz")); // abcdeftz
    }

    public static String removeDuplicatesHashSet(String s) {
        Set<Character> hash = new HashSet<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!hash.contains(c)) {
                hash.add(c);
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String removeDuplicatesBooleanHash(String s) {
        boolean[] hash = new boolean[256];
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!hash[c]) {
                hash[c] = true;
                res.append(c);
            }
        }
        return res.toString();
    }
}
