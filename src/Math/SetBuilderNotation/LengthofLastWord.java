package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int tail = s.length() - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') {
            tail--;
        }
        while (tail >= 0 && s.charAt(tail) != ' ') {
            count++;
            tail--;
        }
        return count;
    }
}
