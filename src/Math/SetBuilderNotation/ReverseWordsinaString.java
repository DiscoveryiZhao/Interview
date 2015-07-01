package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class ReverseWordsinaString {
    public static void main(String[] args) {
        System. out.println(reverseWords( " 1")); // "1"
        System. out.println(reverseWords( "the sky          is blue" )); // "blue is sky the"
    }

    public static String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuffer res = new StringBuffer();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ' ) {
                i--;
            }
            String tmp = " ";
            while (i >= 0 && s.charAt(i) != ' ' ) {
                tmp = s.charAt(i) + tmp;
                i--;
            }
            // "blue "
            // "blue is "
            // "blue is sky "
            // "blue is sky the "
            res.append(tmp);
        }
        // "blue is sky the " to "blue is sky the"
        // " 1" to "1"
        return res.toString().trim();
    }
}
