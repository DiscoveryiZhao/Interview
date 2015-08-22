package HashArrayTable.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] test1 = { 100, 4, 200, 1, 3, 2 }; // 4
		int[] test2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }; // 9
		int[] test3 = { -2, -3, -3, 7, -3, 0, 5, 0, -8, -4, -1, 2 }; // 5
		int[] test4 = { -3, 2, 8, 5, 1, 7, -8, 2, -8, -4, -1, 6, -6, 9, 6, 0, -7, 4, 5, -4, 8, 2, 0, -2, -6, 9, -4, -1 }; // 7
		int[] test5 = { 9000, 8999, 8998, 8997, 8996, 8995, 8994, 8993, 8992, 8991, 8990, 8989, 8988, 8987, 8986, 8985, 8984,
				8983, 8982, 8981, 8980, 8979, 8978, 8977, 8976, 8975, 8974, 8973, 8972, 8971, 8970, 8969, 8968, 8967, 8966, 8965, 8964,
				8963, 8962, 8961, 8960, 8959, 8958, 8957, 8956, 8955, 8954, 8953, 8952, 8951, 8950, 8949, 8948, 8947, 8946,
				8945, 8944, 8943, 8942, 8941, 8940, 8939, 8938 }; // 63

		System.out.println(longestConsecutive(test1));
		System.out.println(longestConsecutive(test2));
		System.out.println(longestConsecutive(test3));
	}

	// 遇到不能排序又要复杂度O(n)有序的问题，只能增加空间复杂度，用hashset或者hashtable
	public static int longestConsecutive(int[] num) {
		Map<Integer, Boolean> visited = new HashMap<>();
		for (int i : num) {
			visited.put(i, false);
		}

		int maxCount = 0;
		for (int i : num) {
			// visited.get(i) == false is true if didn't visited before
			if (visited.get(i) == false) {
				visited.put(i, true);
				int tmpCount = 1;
				int inc = i + 1;
				int dec = i - 1;

				while (visited.containsKey(inc)) {
					visited.put(inc, true);
					inc++;
					tmpCount++;
				}

				while (visited.containsKey(dec)) {
					visited.put(dec, true);
					dec--;
					tmpCount++;
				}
				maxCount = Math.max(maxCount, tmpCount);
			}
		}
		return maxCount;
	}
}
