package Interviews.Google;

/**
 * 给你一个很大的字典。一对词如果不share 任何字母，比如dog, cat不share字母，而dog, boy就share一个o，则是interesting pair.找出所以interesting pairs中长度乘积最大的pair.输出这个乘积。
 */
public class InterestingPairMaxProduct {
    public static void main(String[] args) {
        String[] sa = {"dog", "cat", "boy"};
        System.out.println(getMaxProduct(sa)); // 9
    }

    private static int getMaxProduct(String[] dict){
        String resultA = "";
        String resultB = "";
        int maxProductLength = 0;

        for(int i = 0; i < dict.length; i++){
            for(int j = i; j < dict.length; j++){
                if(noCommon(dict[i],dict[j])){
                    int tmpProductLength = dict[i].length()*dict[j].length();
                    if(tmpProductLength >= maxProductLength){
                        resultA = dict[i];
                        resultB = dict[j];
                        maxProductLength = tmpProductLength;
                    }
                }
            }
        }
        System.out.println("resultA:" + resultA + "  ,resultB:" + resultB);
        return maxProductLength;
    }

    private static boolean noCommon(String s, String t){
        boolean[] hash = new boolean[256];
        for(int i = 0; i < s.length(); i++){
            if(!hash[s.charAt(i)]){
                hash[s.charAt(i)] = true;
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(hash[t.charAt(i)]){
                return false;
            }
        }
        return true;
    }

//    public static int getMaxProduct(String[] sa) {
//        int n = sa.length;
//        int[] bitPattens = new int[n];
//        for (int i = 0; i < n; i++) {
//            bitPattens[i] = getBitPatten(sa[i]);
//        }
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (isInterestingPair(bitPattens[i], bitPattens[j])) {
//                    max = Math.max(max, sa[i].length() * sa[j].length());
//                }
//            }
//        }
//        return max;
//    }
//
//    public static boolean isInterestingPair(int a, int b) {
//        // 应用&运算，如果x &y == 0, 则说明x和y没有任何位match
//        // & 为 and运算, 有0出0。
//        // 00->0
//        // 01->0
//        // 10->0
//        // 11->1
//        return (a & b) != 0;
//    }
//
//    public static int getBitPatten(String w) {
//        int x = 0;
//        for (int i = 0; i < w.length(); i++) {
//            x |= (1 << (Character.toLowerCase(w.charAt(i)) - 'a'));
//        }
//        return x;
//    }
}
