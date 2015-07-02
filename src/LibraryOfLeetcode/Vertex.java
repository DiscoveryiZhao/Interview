package LibraryOfLeetcode;

import java.util.ArrayList;

/**
 * Created by yizhao on 6/30/15.
 */
public class Vertex {
    public int val ;
    public ArrayList<Vertex> neighbors;

    public Vertex(int x) {
        val = x;
        neighbors = new ArrayList<Vertex>();
    }
};