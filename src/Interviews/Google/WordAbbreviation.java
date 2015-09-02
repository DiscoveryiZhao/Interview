package Interviews.Google;

import java.util.*;

/**
 * Created by YZ on 9/2/15.
 */
public class WordAbbreviation {
    public static void main(String[] args){

    }

    /*
    * "abc" -> "a1c", "abbc" ->"a2c", "abdc" ->"a2c"
    * 1. 一个函数计算abbreviation, 长度小于3的直接返回输入,否则取首尾字母,中间插上to_string(s.size()-2)
    * 2. 用unordered_map<string, unordered_set<string>> 存不同abbreviation的string, 遍历所有输入
    * 3. 遍历hash map, 输出set.length() > 1 的set里面的所有string
    * */
    public static List<String> sol(String s){
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 3){
            return res;
        }
        int n = s.length();

        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 1; i < n - 1; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(c + "");
            }else{
                map.put(c+"",new HashSet<String>());
            }
        }

//        for(){
//
//        }

        return res;

    }


    private static void dfs(String ){

    }
}
