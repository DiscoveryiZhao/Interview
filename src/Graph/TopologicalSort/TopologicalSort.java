package Graph.TopologicalSort;


import Library.Leetcode.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class TopologicalSort {
    public static void main(String[] args) {
        // initial graph
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        Vertex seven = new Vertex(7);
        Vertex eight = new Vertex(8);
        Vertex nine = new Vertex(9);

        // 7->1
        // 7->8
        seven. neighbors.add(one);
        seven. neighbors.add(eight);

        // 5->1
        five. neighbors.add(one);

        // 3->8
        // 3->10
        three. neighbors.add(eight);
        three. neighbors.add(four);

        // 1->2
        // 1->9
        // 1->4
        one. neighbors.add(two);
        one. neighbors.add(nine);
        one. neighbors.add(four);

        // 8->9
        eight. neighbors.add(nine);

        Vertex[] set = { one, two, three, four, five, seven, eight, nine };
        // graph[1:2, 2:1, 3:0, 4:2, 5:0,7:0,8:2,9:2]

        // output: [7, 5, 3, 1, 8, 2, 4, 9]
        // output: [7, 3, 5, 8, 1, 2, 9, 4]
        for (Vertex v : toposort(set)) {
            System. out.print(v.val + "," );
        }
    }

    public static ArrayList<Vertex> toposort(Vertex[] set) {
        ArrayList<Vertex> res = new ArrayList<Vertex>();
        Queue<Vertex> q = new LinkedList<Vertex>(); // queue := {all vertices with in-degree = 0}

        HashMap<Vertex, Integer> indegree = new HashMap<Vertex, Integer>(); // <Vetex, in-degree count>
        for (Vertex v : set) {
            indegree.put(v, 0);
        }

        // compute indegrees
        for (Vertex u : set) {
            for (Vertex v : u.neighbors ) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }

        // initialize queue to contain all vertices with indegree = 0
        for (Vertex v : indegree.keySet()) {
            if (indegree.get(v) == 0) {
                q.add(v);
            }
        }

        while (!q.isEmpty()) {
            Vertex u = q.poll();
            res.add(u);
            // update u neighbors and enqueue vertex v with in-degree of 0 (no incoming edges)
            for (Vertex v : u.neighbors ) {
                indegree.put(v, indegree.get(v) - 1); // decrement inward degree count of vertex v
                if (indegree.get(v) == 0) {
                    q.add(v);
                }
            }
        }
        if (res.size() == set.length ) {
            return res;
        } else {
            // There is a cycle
            return null ;
        }
    }
}
