package TwoPointers.SlowFast;

/**
 * Created by yizhao on 6/30/15.
 */
public class CountandSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1)); // "1"
        System.out.println(countAndSay(2)); // "11"
        System.out.println(countAndSay(3)); // "21"
        System.out.println(countAndSay(4)); // "1211"
        System.out.println(countAndSay(5)); // "111221"
        System.out.println(countAndSay(6)); // "312211"
        System.out.println(countAndSay(7)); // "13112221"
    }

    public static String countAndSay(int n) {
        StringBuffer res = new StringBuffer("1");
        while (n > 1) {
            StringBuffer tmp = new StringBuffer();
            int l = 0;
            while (l < res.length()) {
                int count = 1;
                int r = l + 1;
                // counts duplicates
                while (r < res.length() && res.charAt(r - 1) == res.charAt(r)) {
                    count++;
                    r++;
                }
                tmp.append(count).append(res.charAt(l));
                l = r;
            }
            res = tmp;
            n--;
        }
        return res.toString();
    }
}
