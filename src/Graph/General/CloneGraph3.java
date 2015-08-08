package Graph.General;

import Library.Leetcode.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class CloneGraph3 {
    // works in the same way as above dfs code
    public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node, new UndirectedGraphNode(node.label)); // visited.put(u, uCopy)
        q.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode u = q.poll();
            for (UndirectedGraphNode v : u.neighbors) {
                if (!visited.containsKey(v)) {  // Undirected Graph needs a visited hash set to prevent traversal back to the previous visited vertex
                    visited.put(v, new UndirectedGraphNode(v.label)); // visited.put(v, vCopy)
                    q.add(v);
                }
                // worked as uCopy.neighbors.add(vCopy) and vCopy.neighbors.add(uCopy)
                visited.get(u).neighbors.add(visited.get(v));
            }
        }
        return visited.get(node);
    }
}
