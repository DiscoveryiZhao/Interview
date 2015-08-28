package BruteForce;

/*
        Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

        For example:
        Given "aacecaaa", return "aaacecaaa".

        Given "abcd", return "dcbabcd".
*/

import java.util.HashMap;
import java.util.Map;

public class ShortestPalindrome {
    public static void main(String[] args) {
//        System.out.println(shortestPalindrome("aacecaaa")); // aaacecaaa [front:a  ,mid:aacecaa  ,end:a]
//        System.out.println(shortestPalindrome("abcd")); // dcbabcd [front:dcb  ,mid:a  ,end:bcd]
        System.out.println(shortestPalindrome("abb")); // bbabb front:bb  ,mid:a  ,end:bb
//        System.out.println(shortestPalindrome(""));
//        System.out.println(shortestPalindrome(""));
//        System.out.println(shortestPalindrome(""));
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
    }

    public static String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (j >= 0) { //find the first index, which do not make string palindrome 找到第一个使他不回文的位置
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }

        if (i == n) {  //itself is a palindrome 本身是回文
            return s;
        }

        String end = s.substring(i); // 后缀不能够匹配的字符串
        String front = reverseString(end); // 前面补充prefix让他和suffix回文匹配
        String mid = shortestPalindrome(s.substring(0, i)); //递归调用找 [0,i]要最少可以补充多少个字符让他回文
        return front + mid + end;
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
