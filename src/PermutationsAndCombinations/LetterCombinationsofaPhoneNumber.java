package PermutationsAndCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yizhao on 6/26/15.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        // [adg , adh, adi, aeg, aeh, aei , afg, afh, afi, bdg, bdh , bdi, beg, beh, bei, bfg , bfh, bfi, cdg, cdh, cdi , ceg, ceh, cei, cfg, cfh , cfi]
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.equals("")) {
            return res;
        }

        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        vector(digits, res, new StringBuilder(), map);

        return res;
    }

    private static void vector(String digits,
                               List<String> res, StringBuilder tmp, Map<Character, char[]> map) {
        if (tmp.length() == digits.length()) {
            res.add(tmp.toString());
            return;
        }

        for (char c : map.get(digits.charAt(tmp.length()))) {
            tmp.append(c);
            vector(digits, res, tmp, map);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
