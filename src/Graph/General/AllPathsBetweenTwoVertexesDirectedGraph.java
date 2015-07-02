package Graph.General;

import LibraryOfLeetcode.Vertex;

import java.util.ArrayList;
import java.util.List;

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
        for (List<Vertex> tmp : allPaths(one, six)) {
            for (Vertex v : tmp) {
                System. out.print(v.val + "->" );
            }
            System. out.println();
        }
    }

    public static List<List<Vertex>> allPaths(Vertex start, Vertex end) {
        List<List<Vertex>> res = new ArrayList<>();
        dfs(start, end, res, new ArrayList<Vertex>());
        return res;
    }

    private static void dfs(Vertex start, Vertex end, List<List<Vertex>> res, List<Vertex> tmp) {
        tmp.add(start);
        if (start.equals(end)) {
            res.add( new ArrayList<Vertex>(tmp));
        }
        for (Vertex v : start.neighbors ) {
            dfs(v, end, res, tmp);
        }
        tmp.remove(tmp.size() - 1);
    }
}
