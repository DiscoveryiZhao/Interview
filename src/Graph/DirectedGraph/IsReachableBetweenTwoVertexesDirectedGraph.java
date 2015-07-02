package Graph.DirectedGraph;


import LibraryOfLeetcode.Vertex;

/**
 * Created by yizhao on 6/30/15.
 */
public class IsReachableBetweenTwoVertexesDirectedGraph {
    public static void main(String[] args) {
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);
        Vertex five = new Vertex(5);
        Vertex six = new Vertex(6);
        one. neighbors.add(two);
        two. neighbors.add(three);
        three. neighbors.add(four);
        three. neighbors.add(five);
        five. neighbors.add(six);
        System. out.println(isReachable(one, six)); // true
    }

    public static boolean isReachable(Vertex start, Vertex end) {
        return dfs(start, end);
    }


    private static boolean dfs(Vertex start, Vertex end) {
        if (start.equals(end)) {
            return true ;
        }

        for (Vertex v : start.neighbors ) {
            if (dfs(v, end)) {
                return true ;
            }
        }
        return false ;
    }
}
