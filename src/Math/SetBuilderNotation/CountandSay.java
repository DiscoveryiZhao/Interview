package Math.SetBuilderNotation;

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
            int i = 0;
            while (i < res.length()) {
                int count = 1;
                int j = i + 1;
                // counts duplicates
                while (j < res.length() && res.charAt(j - 1) == res.charAt(j)) {
                    count++;
                    j++;
                }
                tmp.append(count).append(res.charAt(i));
                i = j;
            }
            res = tmp;
            n--;
        }
        return res.toString();
    }
}
