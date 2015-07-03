package Graph.General;

import LibraryOfLeetcode.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yizhao on 6/30/15.
 */
public class CloneGraph1 {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        dfs(node, nodeCopy, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
        return nodeCopy;
    }

    private static void dfs(UndirectedGraphNode start, UndirectedGraphNode uCopy, Map<UndirectedGraphNode, UndirectedGraphNode> visited) {
        visited.put(start, uCopy);
        for (UndirectedGraphNode v : start.neighbors) {
            if (!visited.containsKey(v)) {  // Undirected Graph needs a visited hash set to prevent traversal back to the previous visited vertex
                dfs(v, new UndirectedGraphNode(v.label), visited);
            }
            visited.get(start).neighbors.add(visited.get(v));
        }
    }
}
