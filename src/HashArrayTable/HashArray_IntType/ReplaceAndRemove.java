package HashArrayTable.HashArray_IntType;

import java.util.Arrays;

/**
 * Created by yizhao on 12/12/14.
 */
public class ReplaceAndRemove {
    public static void main(String[] args) {
//		System.out.println(replaceAndRemove("a")); // "dd"
//		System.out.println(replaceAndRemove("b")); // ""
//		System.out.println(replaceAndRemove("bc")); // "c"
//		System.out.println(replaceAndRemove("ac")); // "ddc"
//		System.out.println(replaceAndRemove("abc")); // "ddc"
        System.out.println(replaceAndRemove("aaacabbababa")); // "ddddddcdddddddd"
    }

    public static String replaceAndRemove(String s) {
        char[] sChars = s.toCharArray();
        int lengthWithoutB = 0;
        int count_a = 0;
        // Removes "b" and count the number of "a".
        for (char c : sChars) {
            if (c != 'b') sChars[lengthWithoutB++] = c;
            if (c == 'a') count_a++;
        }
        // Allocates space according to the number of "a".
        sChars = Arrays.copyOf(sChars, lengthWithoutB + count_a);
        int tail = lengthWithoutB + count_a - 1;
        lengthWithoutB--;
        // Replace "a" with "dd".
        while (lengthWithoutB >= 0) {
            if (sChars[lengthWithoutB] == 'a') {
                sChars[tail--] = 'd';
                sChars[tail--] = 'd';
            } else {
                // copy chars not a and b
                sChars[tail--] = sChars[lengthWithoutB];
            }
            lengthWithoutB--;
        }
        return new String(sChars);
    }
}
