package HashArrayTable.HashSet;

import java.util.HashSet;

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
        } else {
            HashSet<Character> set = new HashSet<Character>();
            for (char c : s.toCharArray()) {
                if (!set.contains(c)) {
                    set.add(c);
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isUniqueCharsBooleanHash(String s) {
        if (s.length() > 256) {
            return false;
        } else {
            boolean[] hash = new boolean[256];
            for (char c : s.toCharArray()) {
                if (!hash[c]) {
                    hash[c] = true;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
