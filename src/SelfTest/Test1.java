package SelfTest;

/**
 * Created by yizhao on 5/2/15.
 */
public class Test1 {
    public static void main(String[] args) {
        System. out.println(substringAnagram( "afdgksldfmzyx", "xyz" )); // true
        System. out.println(substringAnagram( "afdgzyxksldfm", "xyzk" )); // true
        System. out.println(substringAnagram( "afdgzyxksldfm", "xkyz" )); // true
        System. out.println(substringAnagram( "afdgzyxksldfm", "xyx" )); // false
    }

    public static boolean substringAnagram(String a, String b) {
        int m = a.length(), n = b.length();
        int[] hash = new int[256];
        for (int i = 0; i < n; i++) {
            hash[b.charAt(i)]++;
        }
        for (int i = 0; i < m - n + 1; i++) {
            if (hash[a.charAt(i)] != 0) {
                int[] hashClone = hash.clone();
                if (isAnagram(hashClone, a.substring(i, i + n))) {
                    return true ;
                }
            }
        }
        return false ;
    }

    public static boolean isAnagram(int[] hash, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (--hash[s.charAt(i)] < 0) {
                return false ;
            }
        }
        return true ;
    }
}
