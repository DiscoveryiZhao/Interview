package Interviews.Google;

import java.util.*;

/**
 * Created by YZ on 8/29/15.
 */
public class SystemicString {
    public static void main(String[] args) {
       // System.out.println(Integer.valueOf('8'));

        int n = 1000;
        for (String ss : getAllSystemicString(n)) {
            System.out.println(ss);
        }
    }


    public static List<String> getAllSystemicString(int n) {
        List<String> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        for (int i = 0; i < n; i++) {
            if (i < 10 && (i == 0 || i == 1 || i == 8)) { // 0，1和8翻转后是自己
                result.add(String.valueOf(i));
            } else if (i >= 10 && check(String.valueOf(i), map)) {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }


    private static boolean check(String s, Map<Integer, Integer> map) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            int n = s.charAt(i) - 48;

            if (map.containsKey(n) == false) {
                return false;
            }
            if (map.get(n) != s.charAt(j) - 48) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }

//    private static List<String> getAllSystemicString(int n) {
//        n = Math.abs(n);
//        List<String> result = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 0);
//        map.put(1, 1);
//        map.put(8, 8);
//        map.put(6, 9);
//        map.put(9, 6);
//        map.put(2, 5);
//        map.put(5, 2);
//        result.add("0");
//        for (int i = 0; i <= n; i++) {
//            String candidate = check(i);
//            if (candidate == null) {
//                continue;
//            }
//            String transfer = convert(candidate, map);
//            if (transfer.equals(i + "")) {
//                result.add(candidate);
//
//
//            }
//        }
//        return result;
//    }
//
//    private static String check(int num) {
//        String s = "";
//        while (num > 0) {
//            int digit = num % 10;
//            if (digit == 4 || digit == 3 || digit == 7) {
//                return null;
//            }
//            s += digit;
//            num = num / 10;
//        }
//        return s;
//    }
//
//    private static String convert(String s, Map<Integer, Integer> map) {
//        String result = "";
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            int transfer = map.get(ch - '0');
//            result += transfer;
//        }
//        return result;
//    }
}