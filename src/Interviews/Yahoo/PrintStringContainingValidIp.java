package Interviews.Yahoo;

import java.util.ArrayList;

/**
 * Created by yizhao on 8/17/15.
 */


/*
* 题目：
*
* reverse and print the string which cointans valid IPv4 address
* input: d 127.0.0.1 zxcvb
* expected: bvcxz 1.0.0.72 d
*
* */
public class PrintStringContainingValidIp {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("abc");
        strings.add("d 127.0.0.1 zxcvb");
        strings.add("227.10.3.1 zxcvb");
        strings.add("xyz 123");
        strings.add("1980.02.12");
        strings.add("qwerty 192.168.301.1");

        String pattern = "(.*)([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])(.*)";


        // valid ip address
        // 255.255.255.255
        // (0-255).().().()
        for (String string : strings) {
            // reverse and print the string which cointans valid IPv4 address
            // input: d 127.0.0.1 zxcvb
            // expected: bvcxz 1.0.0.721 d

            // http://www.regular-expressions.info/examples.html
            // \b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b

            // string.matches(pattern)
            // String[] split = string.split(pattern);
            if(string.matches(pattern)){
                System.out.println(reverse(string));
            }


        }
    }

    private static String reverse(String s){
        // StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        char[] charString = s.toCharArray();
        while(left < right){
            char tmp = charString[left];
            charString[left] = charString[right];
            charString[right] = tmp;
            left++;
            right--;
        }

        return new String(charString);

    }

}
