package Graph.General;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class CloneGraph3 {
    // works in the same way as above dfs code
    public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        } else {
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
            visited.put(node, new UndirectedGraphNode(node.label )); // visited.put(u, uCopy)
            q.add(node);
            while (!q.isEmpty()) {
                UndirectedGraphNode u = q.poll();
                for (UndirectedGraphNode v : u.neighbors ) {
                    if (!visited.containsKey(v)) {
                        visited.put(v, new UndirectedGraphNode(v.label )); // visited.put(v, vCopy)
                        q.add(v);
                    }
                    // worked as uCopy.neighbors.add(vCopy) and vCopy.neighbors.add(uCopy)
                    visited.get(u). neighbors.add(visited.get(v));
                }
            }
            return visited.get(node);
        }
    }
}
