package HashArrayTable.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords26 {
	public static void main(String[] args) {
		String[] test1 = { "foo", "bar" };
		System.out.println(findSubstring("barfoothefoobarman", test1)); // [0, 9]

		String[] test2 = { "a", "b" };
		System.out.println(findSubstring("abababab", test2)); // [0, 1, 2, 3, 4, 5, 6]

		String[] test3 = { "a" };
		System.out.println(findSubstring("a", test3)); // [0]
	}

	public static ArrayList<Integer> findSubstring(String S, String[] Dict) {
		int n = S.length();
		int wordLen = Dict[0].length();
		ArrayList<Integer> res = new ArrayList<>();
		// store the map and frequencies in a hash table
		Map<String, Integer> map = new HashMap<>();
		for (String s : Dict) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}

		// find concatenations
		for (int i = 0; i <= n - Dict.length * wordLen; i++) {
			// check if it is a concatenation
			Map<String, Integer> target = new HashMap<>(map);
			for (int j = i; j <= n - wordLen; j += wordLen) {
				String sub = S.substring(j, j + wordLen);
				if (!target.containsKey(sub)) {
					break;
				} else {
					if (target.get(sub) == 1) { // reduce the frequency
						target.remove(sub);
					} else { // remove the word if only one left
						target.put(sub, target.get(sub) - 1);
					}
				}
			}
			if (target.isEmpty()) {
				res.add(i);
			}
		}
		return res;
	}

}
