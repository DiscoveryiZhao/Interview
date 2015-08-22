package HashArrayTable.HashArray_IntType;

import java.util.*;

/**
 * Created by yizhao on 12/12/14.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] s = {"tea", "and", "ace", "ad", "eat", "dan"};
//        [
//          ["ate", "eat","tea"],
//          ["nat","tan"],
//          ["bat"]
//        ]
        System.out.println(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs); // For the return value, each inner list's elements must follow the lexicographic order.
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // create unique label for each string
            String label = stringLabel(s);
            // map the label to a list of anagrams
            if (!map.containsKey(label)) {
                map.put(label, new ArrayList<String>());
            }
            map.get(label).add(s);
        }

        for (List<String> anagram : map.values()) {
            res.add(anagram);
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
                sb.append((char) (i + 'a'));
                sb.append(hash[i]);
            }
        }
        return sb.toString();
    }

    //public static String sortChars(String s) {
    // char[] c = s.toCharArray();
    // Arrays.sort(c);
    // return new String(c);
    //}
}