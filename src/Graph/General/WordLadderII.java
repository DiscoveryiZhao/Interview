package Graph.General;

import java.util.*;

/**
 * Created by yizhao on 6/30/15.
 */
public class WordLadderII {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        Queue<String> q = new LinkedList<String>();// bfs q
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> adjList = new HashMap<String, ArrayList<String>>();
        adjList.put(start, new ArrayList<String>());
        visited.put(start, 1);
        q.add(start);
        while (!q.isEmpty()) {
            String u = q.poll();
            for (int i = 0; i < u.length(); i++) {
                char[] uChar = u.toCharArray();
                for (char j = 'a' ; j <= 'z'; j++) {
                    uChar[i] = j;
                    String v = new String(uChar);
                    if (dict.contains(v)) {
                        if (!visited.containsKey(v)) {
                            adjList.put(v, new ArrayList<String>());
                            visited.put(v, visited.get(u) + 1);
                            q.add(v);
                        }

                        if (visited.get(u) + 1 == visited.get(v)) {
                            adjList.get(u).add(v);
                        }
                    }
                }
            }
        }
        dfsPathBuilder(res, start, end, adjList, new ArrayList<String>());
        return res;
    }

    private static void dfsPathBuilder(ArrayList<ArrayList<String>> res, String u, String end, HashMap<String, ArrayList<String>> adjList, ArrayList<String> tmp) {
        tmp.add(u);
        if (u.equals(end)) {
            res.add( new ArrayList<String>(tmp));
        }
        for (String v : adjList.get(u)) {
            dfsPathBuilder(res, v, end, adjList, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}
