package Leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 5/11/15.
 */
public class IsomorphicStrings {
    public static void main(String[] args){
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("ab", "aa")); // false
        System.out.println(isIsomorphic("ab", "ca")); // true
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length()!=t.length()) return false;

        int n = s.length();
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.containsKey(sc) == false){
                if(map.containsKey(tc)){
                    return false;
                }
                map.put(sc,tc);
            }else{

                if(map.get(sc) != tc){
                    return false;
                }
            }
        }
        return true;
    }
}
