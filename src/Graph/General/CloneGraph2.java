package Graph.General;

import LibraryOfLeetcode.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class CloneGraph2 {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node, new UndirectedGraphNode(node.label)); // visited.put(u, uCopy)
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode u = q.poll();
            for (UndirectedGraphNode v : u.neighbors) {
                if (!visited.containsKey(v)) {  // Undirected Graph needs a visited hash set to prevent traversal back to the previous visited vertex
                    visited.put(v, new UndirectedGraphNode(v.label)); // visited.put(v, vCopy)
                    visited.get(u).neighbors.add(visited.get(v)); // uCopy.neighbors.add(vCopy)
                    q.add(v);
                } else {
                    visited.get(u).neighbors.add(visited.get(v)); // vCopy.neighbors.add(uCopy)
                }
            }
        }
        return visited.get(node);
    }
}
