package SelfTest;

/**
 * Created by yizhao on 5/2/15.
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println(sol(4)); // 输出：8
    }

    public static int sol(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return sol(n - 1) * sol(n - 2);
        }
    }

//    private static int sol(String[] dict){
//        String resultA = "";
//        String resultB = "";
//        int maxProductLength = 0;
//
//        for(int i = 0; i < dict.length; i++){
//            for(int j = i; j < dict.length; j++){
//                if(noCommon(dict[i],dict[j])){
//                    int tmpProductLength = dict[i].length()*dict[j].length();
//                    if(tmpProductLength >= maxProductLength){
//                        resultA = dict[i];
//                        resultB = dict[j];
//                        maxProductLength = tmpProductLength;
//                    }
//                }
//            }
//        }
//        System.out.println("resultA:" + resultA + "  ,resultB:" + resultB);
//        return maxProductLength;
//    }
//
//    private static boolean noCommon(String s, String t){
//        boolean[] hash = new boolean[256];
//        for(int i = 0; i < s.length(); i++){
//            if(!hash[s.charAt(i)]){
//                hash[s.charAt(i)] = true;
//            }
//        }
//
//        for(int i = 0; i < t.length(); i++){
//            if(hash[t.charAt(i)]){
//                return false;
//            }
//        }
//        return true;
//    }
}
