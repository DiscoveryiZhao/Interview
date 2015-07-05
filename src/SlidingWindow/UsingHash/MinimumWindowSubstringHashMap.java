package SlidingWindow.UsingHash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 7/1/15.
 */
public class MinimumWindowSubstringHashMap {
    public static void main(String[] args) {
        System. out.println(minWindow( "ADOBECODEBANC", "ABC" )); // BANC
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> hashT = new HashMap<>();
        Map<Character, Integer> hasFound = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!hashT.containsKey(c)) {
                hashT.put(c, 1);
            } else {
                hashT.put(c, hashT.get(c) + 1);
            }
        }

        String window = "";
        int found = 0;
        int L = 0;
        for (int R = 0; R < s.length(); R++) {
            if (!hashT.containsKey(s.charAt(R))) continue;
            if (!hasFound.containsKey(s.charAt(R))) {
                hasFound.put(s.charAt(R), 1);
            } else {
                hasFound.put(s.charAt(R), hasFound.get(s.charAt(R)) + 1);
            }
            if (hasFound.get(s.charAt(R)) <= hashT.get(s.charAt(R))) found++;
            if (found == t.length()) {
                while (!hashT.containsKey(s.charAt(L)) || hasFound.get(s.charAt(L)) > hashT.get(s.charAt(L))) {
                    if (hasFound.containsKey(s.charAt(L))) hasFound.put(s.charAt(L), hasFound.get(s.charAt(L)) - 1);
                    L++;
                }
                if (window.length() == 0 || R - L < window.length()) window = s.substring(L, R + 1);
            }
        }
        return window;
    }

}
