package Interviews.Google;

/**
 * Created by YZ on 9/1/15.
 */
public class HTMLTree {
    HTMLTree root;
    HTMLNode[] child;
    public boolean compare(HTMLTree t1, HTMLTree t2) {
        String s1 = getText(t1.root);
        String s2 = getText(t2.root);
        return s1.equals(s2);
    }

    public String getText(HTMLTree t) {
        String res = "";
        if (t == null) {
            return res;
        }

        if (t.child != null) {
            for (HTMLNode n : t.child) {
                res += n.getText();
            }
        }
        return res;
    }

}

class HTMLNode {
    String tag;
    String text;

    public String getText() {
        return text;
    }
}

