package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

        For example,
        Given "egg", "add", return true.

        Given "foo", "bar", return false.

        Given "paper", "title", return true.

        Note:
        You may assume both s and t have the same length.
*/
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("ab", "aa")); // false
        System.out.println(isIsomorphic("ab", "ca")); // true
        System.out.println(isIsomorphic("aba", "baa")); // false
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int n = s.length();
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (sMap.containsKey(sc) == false) {
                sMap.put(sc, tc);
            } else {
                if (sMap.get(sc) != tc) {
                    return false;
                }
            }

            if (tMap.containsKey(tc) == false) {
                tMap.put(tc, sc);
            } else {
                if (tMap.get(tc) != sc) {
                    return false;
                }
            }
        }
        return true;
    }
}
