package HashArrayTable.HashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
public class RepeatedDNASequences {
    public static void main(String[] args){
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // [AAAAACCCCC, CCCCCAAAAA]
    }


    /*
    * reference: http://blog.csdn.net/youmengjiuzhuiba/article/details/45768605
    * 遍历字符串，用hashmap存储字串，判断即可
    * */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> rs = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String substr = s.substring(i, i + 10);
            if (map.containsKey(substr)) {
                map.put(substr, map.get(substr) + 1);
            } else {
                map.put(substr, 1);
            }
        }

        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() > 1) {
                rs.add(en.getKey());
            }
        }
        return rs;
    }
}
