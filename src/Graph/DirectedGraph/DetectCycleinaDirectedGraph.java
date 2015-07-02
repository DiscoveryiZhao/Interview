package Graph.DirectedGraph;


import LibraryOfLeetcode.Vertex;

import java.util.HashSet;

/**
 * Created by yizhao on 6/30/15.
 */

public class DetectCycleinaDirectedGraph {
    public static void main(String[] args) {
        Vertex first = new Vertex(1);
        Vertex second = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        Vertex seven = new Vertex(7);
        Vertex eight = new Vertex(8);
        Vertex nine = new Vertex(9);

        /* Vertex 1 has neighbors{2, 3} */
        first.neighbors.add(second);
        first.neighbors.add(three);
        System.out.println(isCyclic(first)); // false

        /* Vertex 4 has neighbors{4} itself */
        four.neighbors.add(four);
        System.out.println(isCyclic(four)); // true

        /* Vertex 5 has neighbors{6,7,8} */
        /* Vertex 8 has neighbors{9} */
        /* Vertex 9 has neighbors{5} */
        five.neighbors.add(six);
        five.neighbors.add(seven);
        five.neighbors.add(eight);
        eight.neighbors.add(nine);
        nine.neighbors.add(five);
        System.out.println(isCyclic(five)); // true
    }

    public static boolean isCyclic(Vertex node) {
        if (node == null) {
            return false;
        } else {
            return dfs(node, new HashSet<Vertex>());
        }
    }

    private static boolean dfs(Vertex u, HashSet<Vertex> visited) {
        visited.add(u);
        for (Vertex v : u.neighbors) {
            if (!visited.contains(v)) {
                if (dfs(v, visited)) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }
}
