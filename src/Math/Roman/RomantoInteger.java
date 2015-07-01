package Math.Roman;

import java.util.HashMap;

/**
 * Created by yizhao on 6/30/15.
 */
public class RomantoInteger {
    public static int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put( 'M', 1000);
        map.put( 'D', 500);
        map.put( 'C', 100);
        map.put( 'L', 50);
        map.put( 'X', 10);
        map.put( 'V', 5);
        map.put( 'I', 1);

        for (int i = 0; i < n; i++) {
            int integer = map.get(s.charAt(i));
            if ((i + 1 < n) && (map.get(s.charAt(i + 1)) > integer)) {
                // V-I = 5 - 1
                // X-I = 10 - 1
                // L-X = 50 - 10
                // C-X = 100 - 10
                // D-C = 500 - 100
                // M-C = 1000 - 100
                integer = map.get(s.charAt(i + 1)) - integer;
                i++;
            }
            res += integer;
        }
        return res;
    }
}
