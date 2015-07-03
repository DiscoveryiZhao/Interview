package Graph.General;

import java.util.*;

/**
 * Created by yizhao on 6/30/15.
 */
public class WordLadder {
    public static int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<>();// bfs q
        Map<String, Integer> visited = new HashMap<>();
        visited.put(start, 1);
        q.add(start);
        while (!q.isEmpty()) {
            String start2 = q.poll();
            if (start2.equals(end)) {
                return visited.get(start2);
            }
            for (int i = 0; i < start2.length(); i++) {
                char[] uChar = start2.toCharArray();
                for (char j = 'a' ; j <= 'z'; j++) {
                    uChar[i] = j;
                    String v = new String(uChar);
                    if (dict.contains(v)) {
                        if (!visited.containsKey(v)) {
                            visited.put(v, visited.get(start2) + 1);
                            q.add(v);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
