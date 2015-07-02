package Graph.General;

import LibraryOfLeetcode.UndirectedGraphNode;

import java.util.HashMap;

/**
 * Created by yizhao on 6/30/15.
 */
public class CloneGraph1 {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null ;
        } else {
            UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label );
            dfs(node, nodeCopy, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
            return nodeCopy;
        }
    }

    private static void dfs(UndirectedGraphNode u, UndirectedGraphNode uCopy, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
        visited.put(u, uCopy);
        for (UndirectedGraphNode v : u.neighbors ) {
            if (!visited.containsKey(v)) {
                dfs(v, new UndirectedGraphNode(v. label), visited);
            }
            visited.get(u). neighbors.add(visited.get(v));
        }
    }
}
