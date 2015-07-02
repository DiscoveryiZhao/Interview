package SlidingWindow.UsingHash;

/**
 * Created by yizhao on 7/1/15.
 */
public class LongestSubstringWithoutRepeatingCharactersReturnSubstring {
    public static String longestSubstringWithoutRepeatingCharacters(String s) {
        int n = s.length();
        boolean[] hash = new boolean[256];
        String res = "";
        int L = 0;
        int R = 0;
        while (R < n) {
            // a[L..R-1] satisfy !hash[s.charAt(right)]
            while (R < n && !hash[s.charAt(R)]) hash[s.charAt(R++)] = true;
            if(res.length() == 0 ||R - L > res.length() ){
                res = s.substring(L, R);
            }
            // find K
            while (R < n && s.charAt(L) != s.charAt(R)) hash[s.charAt(L++)] = false;
            L++; R++;
        }
        return res;
    }

}
