package Graph.DirectedGraph;


import Library.Leetcode.Vertex;

import java.util.*;

/**
 * Created by yizhao on 6/30/15.
 */
public class ShortestPathBetweenTwoVertexes {
    public static void main(String[] args) {
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        one.neighbors.add(two);
        two.neighbors.add(three);
        two.neighbors.add(four);
        three.neighbors.add(four);
        three.neighbors.add(five);
        four.neighbors.add(six);
        five.neighbors.add(six);
        // 1->2->4->6
        for (Vertex v : shortestPath(one, six)) {
            System.out.print(v.val + "->");
        }
    }

    public static List<Vertex> shortestPath(Vertex start, Vertex end) {
        Map<Vertex, Vertex> visited = new HashMap<>();
        Queue<Vertex> q = new LinkedList<>();
        visited.put(start, null);
        q.add(start);
        while (!q.isEmpty()) {
            Vertex u = q.poll();
            if (u.equals(end)) {
                return pathBuilder(end, visited); // Path founded.
            }
            for (Vertex v : u.neighbors) {
                if (!visited.containsKey(v)) {  // Undirected Graph needs a visited hash set to prevent traversal back to the previous visited vertex
                    visited.put(v, u);
                    q.add(v);
                }
            }
        }
        return null;
    }

    private static List<Vertex> pathBuilder(Vertex v, Map<Vertex, Vertex> visited) {
        LinkedList<Vertex> path = new LinkedList<>();
        while (v != null) {
            path.addFirst(v);
            v = visited.get(v);
        }
        return path;
    }
}