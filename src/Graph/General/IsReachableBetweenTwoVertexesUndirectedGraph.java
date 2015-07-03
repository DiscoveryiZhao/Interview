package Graph.General;

import LibraryOfLeetcode.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yizhao on 6/30/15.
 */
public class IsReachableBetweenTwoVertexesUndirectedGraph {
    public static void main(String[] args) {
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        one. neighbors.add(two);
        two. neighbors.add(one);
        two. neighbors.add(three);
        three. neighbors.add(two);
        three. neighbors.add(four);
        four. neighbors.add(three);
        three. neighbors.add(five);
        five. neighbors.add(three);
        three. neighbors.add(one);
        one. neighbors.add(three);
        five. neighbors.add(six);
        six. neighbors.add(five);
        System. out.println(isReachable(one, six)); // true
    }

    public static boolean isReachable(Vertex start, Vertex end) {
        return dfs(start, end, new HashSet<Vertex>());
    }

    private static boolean dfs(Vertex start, Vertex end, Set<Vertex> visited) {
        visited.add(start);
        if (start.equals(end)) {
            return true ;
        }

        for (Vertex v : start.neighbors ) {
            if (!visited.contains(v)) { //Undirected Graph needs a visited hash set to prevent traversal back to the previous visited vertex
                if (dfs(v, end, visited)) {
                    return true ;
                }
            }
        }
        return false ;
    }
}
