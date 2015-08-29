package HashArrayTable.HashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by YZ on 8/29/15.
 */
public class RepeatedDNASequences {
    public static void main(String[] args){
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")); // [AAAAACCCCC, CCCCCAAAAA]
    }

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
