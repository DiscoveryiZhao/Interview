package HashArrayTable.HashArray_IntType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 12/12/14.
 */
public class Anagrams {
    public static void main(String[] args) {
        String[] s = { "tea", "and", "ace", "ad", "eat", "dan" };
        System.out.println(anagrams(s)); // [tea, eat, and, dan]
    }

    public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            // create unique label for each string
            String label = stringLabel(s);
            // map the label to a list of anagrams
            if (!map.containsKey(label)) {
                map.put(label, new ArrayList<String>());
            }
            map.get(label).add(s);
        }

        for (ArrayList<String> anagram : map.values()) {
            // 长度大于1，说明这个String有anagram
            if (anagram.size() > 1) {
                res.addAll(anagram);
            }
        }
        return res;
    }

    /*
     * O(n) for time
     * create a unique label for a string "cat", "atc" => a1c1t1
     */
    public static String stringLabel(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                sb.append((char) ('a' + i));
                sb.append(hash[i]);
            }
        }
        return sb.toString();
    }

    //public static String sortChars(String s) {
    //	char[] c = s.toCharArray();
    //	Arrays.sort(c);
    //	return new String(c);
    //}
}
