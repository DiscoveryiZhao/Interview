package Graph.General;

import java.util.*;

/**
 * Created by yizhao on 6/30/15.
 */
public class WordLadderII {
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<>();
        Queue<String> q = new LinkedList<String>();// bfs q
        Map<String, Integer> visited = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();
        adjList.put(start, new ArrayList<String>());
        visited.put(start, 1);
        q.add(start);
        while (!q.isEmpty()) {
            String start2 = q.poll();
            for (int i = 0; i < start2.length(); i++) {
                char[] uChar = start2.toCharArray();
                for (char j = 'a' ; j <= 'z'; j++) {
                    uChar[i] = j;
                    String v = new String(uChar);
                    if (dict.contains(v)) {
                        if (!visited.containsKey(v)) {
                            adjList.put(v, new ArrayList<String>());
                            visited.put(v, visited.get(start2) + 1);
                            q.add(v);
                        }

                        if (visited.get(start2) + 1 == visited.get(v)) {
                            adjList.get(start2).add(v);
                        }
                    }
                }
            }
        }
        dfsPathBuilder(res, start, end, adjList, new ArrayList<String>());
        return res;
    }

    private static void dfsPathBuilder(List<List<String>> res, String start, String end, Map<String, List<String>> adjList, List<String> tmp) {
        tmp.add(start);
        if (start.equals(end)) {
            res.add( new ArrayList<String>(tmp));
        }
        for (String v : adjList.get(start)) {
            dfsPathBuilder(res, v, end, adjList, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}
