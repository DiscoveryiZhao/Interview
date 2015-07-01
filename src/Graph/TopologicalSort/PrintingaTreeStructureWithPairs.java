package Graph.TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yizhao on 6/30/15.
 */
public class PrintingaTreeStructureWithPairs {
    public static void main(String[] args) {
        Pairs one = new Pairs("a", "b");
        Pairs two = new Pairs("b", "c");
        Pairs three = new Pairs("a", "d");
        Pairs four = new Pairs("d", "e");
        Pairs five = new Pairs("d", "f");
        Pairs six = new Pairs("d", "g");

        ArrayList<Pairs> set = new ArrayList<Pairs>();
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);
        set.add(five);
        set.add(six);

        // a
        // _b
        // _d
        // __c
        // __e
        // __f
        // __g
        printingaTreeStructureWithPairs(set);
    }

    public static void printingaTreeStructureWithPairs(ArrayList<Pairs> set) {
        /* Computes in-degree and build adjacList*/
        HashMap<String, Integer> indegree = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> adjacList = new HashMap<String, ArrayList<String>>();
        for (Pairs s : set) {
            adjacList.put(s.first, new ArrayList<String>());
            indegree.put(s.first, 0);
            indegree.put(s.second, 0);
        }

        for (Pairs s : set) {
            adjacList.get(s.first).add(s.second);
            indegree.put(s.second, indegree.get(s.second) + 1);
        }

        String start = "";
        for (String s : indegree.keySet()) {
            if (indegree.get(s) == 0) {
                start = s;
                break;
            }
        }

        /* Print the tree*/
        Queue<String> q = new LinkedList<String>(); // queue := {all vertices with in-degree = 0}
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        q.add(start);
        visited.put(start, 0);
        while (!q.isEmpty()) {
            String u = q.poll();
            for (int i = 0; i < visited.get(u); i++) {
                System.out.print("_");
            }
            System.out.println(u);
            // update u neighbors and enqueue vertex v with in-degree of 0 (no incoming edges)
            if (adjacList.containsKey(u)) {
                for (String v : adjacList.get(u)) {
                    visited.put(v, visited.get(u) + 1);
                    indegree.put(v, indegree.get(v) - 1); // decrement inward degree count of vertex v
                    if (indegree.get(v) == 0) {
                        q.add(v);
                    }
                }
            }
        }
    }
}

class Pairs{
    String first;
    String second;
    public Pairs(String first, String second){
        this.first = first;
        this.second = second;
    }
}