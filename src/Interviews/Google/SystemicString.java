package Interviews.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YZ on 8/29/15.
 */
public class SystemicString {
    public static void main(String[] args) {
        int n = 10000;
        for (String ss : getAllSystemicString(n)) {
            System.out.println(ss);
        }
    }

    private static List<String> getAllSystemicString(int n) {
        n = Math.abs(n);
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        map.put(6, 9);
        map.put(9, 6);
        map.put(2, 5);
        map.put(5, 2);
        result.add("0");
        for (int i = 0; i <= n; i++) {
            String candidate = check(i);
            if (candidate == null) {
                continue;
            }
            String transfer = convert(candidate, map);
            if (transfer.equals(i + "")) {
                result.add(candidate);


            }
        }
        return result;
    }

    private static String check(int num) {
        String s = "";
        while (num > 0) {
            int digit = num % 10;
            if (digit == 4 || digit == 3 || digit == 7) {
                return null;
            }
            s += digit;
            num = num / 10;
        }
        return s;
    }

    private static String convert(String s, Map<Integer, Integer> map) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int transfer = map.get(ch - '0');
            result += transfer;
        }
        return result;
    }
}