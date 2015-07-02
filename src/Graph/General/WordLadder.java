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
            String u = q.poll();
            if (u.equals(end)) {
                return visited.get(u);
            }
            for (int i = 0; i < u.length(); i++) {
                char[] uChar = u.toCharArray();
                for (char j = 'a' ; j <= 'z'; j++) {
                    uChar[i] = j;
                    String v = new String(uChar);
                    if (dict.contains(v)) {
                        if (!visited.containsKey(v)) {
                            visited.put(v, visited.get(u) + 1);
                            q.add(v);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
