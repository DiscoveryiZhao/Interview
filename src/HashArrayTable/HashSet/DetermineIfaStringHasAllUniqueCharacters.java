package HashArrayTable.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 12/12/14.
 */
public class DetermineIfaStringHasAllUniqueCharacters {
    public static void main(String[] args) {
        System.out.println(isUniqueCharsHashSet("abc")); // true
        System.out.println(isUniqueCharsHashSet("abca")); // false
        System.out.println(isUniqueCharsBooleanHash("abc")); // true
        System.out.println(isUniqueCharsBooleanHash("abca")); // false
    }

    public static boolean isUniqueCharsHashSet(String s) {
        if (s.length() > 256) {
            return false;
        }
        Set<Character> hash = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (hash.contains(c)) {
                return false;
            } else {
                hash.add(c);
            }
        }
        return true;
    }

    public static boolean isUniqueCharsBooleanHash(String s) {
        if (s.length() > 256) {
            return false;
        }
        boolean[] hash = new boolean[256];
        for (char c : s.toCharArray()) {
            if (hash[c]) {
                return false;
            } else {
                hash[c] = true;
            }
        }
        return true;
    }
}
