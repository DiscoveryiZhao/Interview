package GoogleInterviewPrepare;

/**
 * 假设有一个 dictionary 和一个String，找到从String中能组成的存在于dictionary 中的 最长的 word。
 */
public class LongestDictionaryWord {
    public static void main(String[] args) {
        String[] dict1 = { "abc", "kdiaubyect" , "kdiaubyexyasdet" };
        System. out.println(longestDictionaryWord(dict1, "abc")); // kdiaubyect

        String[] dict2 = { "abc", "kdiaubyect" , "kdiaubyexcyasdet" };
        System. out.println(longestDictionaryWord(dict2, "abc")); // kdiaubyexcyasdet
    }

    public static String longestDictionaryWord(String[] dict, String target) {
        int n = dict.length ;
        int[] hash = new int[256];
        for (char c : target.toCharArray()) {
            hash[c]++;
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            int[] clone = hash.clone();
            if (contains(dict[i], target, clone)) {
                if (dict[i].length() >= res.length()) {
                    res = dict[i];
                }
            }
        }
        return res;
    }

    public static boolean contains(String s, String target, int[] hash) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (hash[c] != 0) {
                hash[c]--;
                count++;
            }
            if (count == target.length()) {
                return true ;
            }
        }
        return false ;
    }
}
