package HashArrayTable.HashArray_IntType;

/**
 * Created by yizhao on 12/12/14.
 */
public class HalfTime {
    public static void main(String[] args){
        String s1 = "abadacababaaaa";
        System.out.println(halfTime(s1)); // a
        String s2 = "abcdeabbad";
        System.out.println(halfTime(s2)); // null
        String s3 = "aabb";
        System.out.println(halfTime(s3)); // null
    }

    public static Character halfTime(String s){
        int n = s.length();
        if(n == 0){
            return null;
        }else{
            int[] hash = new int[256];
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                hash[c]++;
                if(hash[c]  > n/2){
                    return c;
                }
            }
            return null;
        }
    }
}
