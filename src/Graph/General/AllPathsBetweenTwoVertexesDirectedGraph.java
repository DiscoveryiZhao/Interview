package Graph.General;

import LibraryOfLeetcode.Vertex;

import java.util.ArrayList;

/**
 * Created by yizhao on 6/30/15.
 */
public class AllPathsBetweenTwoVertexesDirectedGraph {
    public static void main(String[] args) {
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        one. neighbors.add(two);
        two. neighbors.add(three);
        two. neighbors.add(four);
        three. neighbors.add(four);
        three. neighbors.add(five);
        four. neighbors.add(six);
        five. neighbors.add(six);

        // 1->2->3->4->6->
        // 1->2->3->5->6->
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
        dfs(start, end, res, new ArrayList<Vertex>());
        return res;
    }

    private static void dfs(Vertex u, Vertex end, ArrayList<ArrayList<Vertex>> res, ArrayList<Vertex> tmp) {
        tmp.add(u);
        if (u.equals(end)) {
            res.add( new ArrayList<Vertex>(tmp));
        }
        for (Vertex v : u.neighbors ) {
            dfs(v, end, res, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}
