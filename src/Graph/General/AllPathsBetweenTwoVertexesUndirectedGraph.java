package Graph.General;

import LibraryOfLeetcode.Vertex;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by yizhao on 6/30/15.
 */
public class AllPathsBetweenTwoVertexesUndirectedGraph {
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
        two. neighbors.add(four);
        four. neighbors.add(two);
        three. neighbors.add(four);
        four. neighbors.add(three);
        three. neighbors.add(five);
        five. neighbors.add(three);
        four. neighbors.add(six);
        six. neighbors.add(four);
        five. neighbors.add(six);
        six. neighbors.add(five);

        // 1->2->3->4->6->
        // 1->2->3->5->6->
        // 1->2->4->3->5->6->
        // 1->2->4->6->
        for (ArrayList<Vertex> tmp : allPaths(one, six)) {
            for (Vertex v : tmp) {
                System. out.print(v.val + "->" );
            }
            System. out.println();
        }
    }

    public static ArrayList<ArrayList<Vertex>> allPaths(Vertex start, Vertex end) {
        ArrayList<ArrayList<Vertex>> res = new ArrayList<ArrayList<Vertex>>();
        dfs(start, end, res, new ArrayList<Vertex>(), new HashSet<Vertex>());
        return res;
    }

    private static void dfs(Vertex u, Vertex end, ArrayList<ArrayList<Vertex>> res, ArrayList<Vertex> tmp, HashSet<Vertex> visited) {
        visited.add(u);
        tmp.add(u);
        if (u.equals(end)) {
            res.add( new ArrayList<Vertex>(tmp));
        }
        for (Vertex v : u.neighbors ) {
            if (!visited.contains(v)) {
                dfs(v, end, res, tmp, visited);
            }
        }
        tmp.remove(tmp.size() - 1);
        visited.remove(u);
    }
}
