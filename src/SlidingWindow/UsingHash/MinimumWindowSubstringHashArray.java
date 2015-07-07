package SlidingWindow.UsingHash;

/**
 * Created by yizhao on 7/1/15.
 */
public class MinimumWindowSubstringHashArray {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
    }

    public static String minWindow(String s, String t) {
        int[] hashT = new int[256];
        int[] hasFound = new int[256];
        for (int i = 0; i < t.length(); i++) hashT[t.charAt(i)]++;

        String window = "";
        int found = 0;
        int L = 0;
        for (int R = 0; R < s.length(); R++) {
            if (hashT[s.charAt(R)] == 0) continue;
            hasFound[s.charAt(R)]++;
            if (hasFound[s.charAt(R)] <= hashT[s.charAt(R)]) found++;
            if (found == t.length()) {
                // left stops at hashT[S.charAt(left)] != 0 && hasFound[S.charAt(left)] <= hashT[S.charAt(left)]
                while (hashT[s.charAt(L)] == 0 || hasFound[s.charAt(L)] > hashT[s.charAt(L)]) {
                    if (hashT[s.charAt(L)] != 0) hasFound[s.charAt(L)]--; // reduce frequency
                    L++; // reduce windows size
                }
                if (window.length() == 0 || R - L < window.length()) {
                    window = s.substring(L, R + 1);
                }
            }
        }
        return window;
    }
}
