package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 12/23/14.
 */
public class DFSCutBranch {
    public static void main(String[] args) {
        graphExample1();
        graphExample2();
    }

    public static void graphExample1() {
         /* Setup initial value*/
        Vertx root1 = new Vertx(1);
        Vertx root2 = new Vertx(2);
        Vertx root3 = new Vertx(3);
        Vertx root4 = new Vertx(4);
        Vertx root5 = new Vertx(5);
        Vertx root6 = new Vertx(6);
        Vertx root7 = new Vertx(7);
        Vertx root8 = new Vertx(8);
        Vertx root9 = new Vertx(9);
        Vertx root10 = new Vertx(10);

        /* Setup children*/
        root1.getChild().add(root2);
        root1.getChild().add(root3);
        root2.getChild().add(root4);
        root2.getChild().add(root5);
        root3.getChild().add(root6);
        root3.getChild().add(root7);
        root4.getChild().add(root8);
        root5.getChild().add(root9);
        root6.getChild().add(root10);

        /* Traversal the Grapth*/
        List<Vertx> res = graphTraversal(root1);

        /* Print the result*/
        for (Vertx v : res) {
            System.out.print(v.getLable() + ",");
        }
        System.out.println();
    }

    public static void graphExample2() {
        /* Setup initial value*/
        Vertx root1 = new Vertx(1);
        Vertx root2 = new Vertx(2);
        Vertx root3 = new Vertx(3);
        Vertx root4 = new Vertx(4);
        Vertx root5 = new Vertx(5);
        Vertx root6 = new Vertx(6);
        Vertx root7 = new Vertx(7);
        Vertx root8 = new Vertx(8);
        Vertx root9 = new Vertx(9);
        Vertx root10 = new Vertx(10);

        /* Setup children*/
        root1.getChild().add(root2);
        root1.getChild().add(root3);
        root1.getChild().add(root4);
        root1.getChild().add(root5);
        root2.getChild().add(root6);
        root3.getChild().add(root7);
        root3.getChild().add(root8);
        root3.getChild().add(root9);
        root5.getChild().add(root10);

        /* Traversal the Grapth*/
        List<Vertx> res = graphTraversal(root1);

        /* Print the result*/
        for (Vertx v : res) {
            System.out.print(v.getLable() + ",");
        }
        System.out.println();
    }


    public static List<Vertx> graphTraversal(Vertx start) {
        List<Vertx> res = new ArrayList<Vertx>();
        if (NotToCutBranch(start.getLable())) {
            res.add(start);
            vectorTraversal(start, res);
        }
        return res;
    }

    private static boolean vectorTraversal(Vertx start, List<Vertx> res) {
        if (start == null) {
            return false;
        } else {
            if(domainTraversal(start, res)){
                return true;
            }
            return false;
        }
    }

    private static boolean domainTraversal(Vertx start, List<Vertx> res){
        for (Vertx v : start.getChild()) {
                /* False then do 剪枝*/
            if (NotToCutBranch(v.getLable())) {
                res.add(v);
                if (vectorTraversal(v, res)) {
                    return true;
                }

            }
        }
        return false;
    }

    /*True if i is odd number*/
    private static boolean NotToCutBranch(int i) {
        return i % 2 != 0;
    }

    private static class Vertx {
        private int lable = 0;
        private List<Vertx> child = null;

        public Vertx(int lable) {
            this.lable = lable;
            child = new ArrayList<Vertx>();
        }

        public List<Vertx> getChild() {
            return child;
        }

        public void setChild(List<Vertx> child) {
            this.child = child;
        }

        public int getLable() {
            return lable;
        }

        public void setLable(int lable) {
            this.lable = lable;
        }
    }
}
