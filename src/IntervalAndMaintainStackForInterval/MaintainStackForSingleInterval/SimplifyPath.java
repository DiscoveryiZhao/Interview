package IntervalAndMaintainStackForInterval.MaintainStackForSingleInterval;

import java.util.Stack;

/**
 * Created by yizhao on 7/7/15.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        // split by "/"
        // from "/home/" to [, home]
        // from "/a/./b/../../c/" to [, a, ., b, .., .., c]
        // from "/../" to [, ..]
        // from "/home// foo/" to [, home, , foo]
        String[] splits = path.split( "/");

        Stack<String> leftStack = new Stack<>();
        int right = 0;
        while (right < splits.length ) {
            String s = splits[right];
            if (!s.equals("" ) && !s.equals(".") && !s.equals( "..")) {
                leftStack.push(s); // leftStack only push a,b,c and English words
            } else {
                // true if no matching left
                if (leftStack.isEmpty()) {
                    // do nothing
                } else {
                    // ".." go back to previous folder so we pop the current folder
                    if (s.equals(".." )) {
                        leftStack.pop();
                    }
                }
            }
            right++;
        }

        // print new path
        if (leftStack.isEmpty()) {
            return "/" ;
        } else {
            String res = "";
            while (!leftStack.isEmpty()) {
                res = "/" + leftStack.pop() + res;
            }
            return res;
        }
    }
}
