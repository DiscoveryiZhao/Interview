package BruteForce;

/*
        Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

        For example:
        Given "aacecaaa", return "aaacecaaa".

        Given "abcd", return "dcbabcd".
*/

public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // aaacecaaa
//        System.out.println(shortestPalindrome("abcd")); // dcbabcd
//        System.out.println(shortestPalindrome("abb"));
//        System.out.println(shortestPalindrome(""));
//        System.out.println(shortestPalindrome(""));
//        System.out.println(shortestPalindrome(""));
    }

    public static String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (j >= 0) { //找到第一个使他不回文的位置
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }

        if (i == n) {  //本身是回文
            return s;
        }

        String front = s.substring(i); // 后缀不能够匹配的字符串
        System.out.println("front:" + front + "  ,i:" + i);
        String end = reverseString(front); // 前面补充prefix让他和suffix回文匹配
        String mid = shortestPalindrome(s.substring(0, i)); //递归调用找 [0,i]要最少可以补充多少个字符让他回文
        return end + mid + front;
    }

    private static String reverseString(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
        return new String(c);
    }
}
