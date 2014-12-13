package HashArrayTable.HashMap;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		int[] test1 = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(test1, 9))); // [1, 2]
	}

	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null) {
			return null;
		} else {
			int[] res = new int[2];
			HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
			for (int i = 0; i < numbers.length; i++) {
				if (mp.containsKey(target - numbers[i])) {
					res[0] = mp.get(target - numbers[i]);
					res[1] = i + 1;
					return res;
				}
				mp.put(numbers[i], i + 1);
			}
			return res;
		}
	}
}
