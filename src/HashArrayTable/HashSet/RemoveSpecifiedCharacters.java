package HashArrayTable.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 12/12/14.
 */
public class RemoveSpecifiedCharacters {
    public static void main(String[] args) {
        char[] needToRemove = { 'a', 'e', 'i', 'o', 'u' };
        // Bttl f th Vwls: Hw vs. Grzny
        System.out.println(removeSpecifiedCharactersHashSet("Battle of the Vowels: Hawaii vs. Grozny", needToRemove));
        // Bttl f th Vwls: Hw vs. Grzny
        System.out.println(removeSpecifiedCharactersBooleanHash("Battle of the Vowels: Hawaii vs. Grozny", needToRemove));
    }

    public static String removeSpecifiedCharactersHashSet(String s, char[] needToRemove) {
        Set<Character> hash = new HashSet<>();
        for (char c : needToRemove) {
            hash.add(c);
        }

        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!hash.contains(c)) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String removeSpecifiedCharactersBooleanHash(String s, char[] needToRemove) {
        boolean[] hash = new boolean[256];
        for (char c : needToRemove) {
            hash[c] = true;
        }

        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!hash[c]) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
