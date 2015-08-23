package DataStructure.Iterator;

import java.util.*;

/**
 * Created by YZ on 8/23/15.
 */
public class RotateIteratorMain {
    public static void main(String[] args) {
        // 输入: [[7,8,9],[],[2,3,5],[1,19]]
        // 输出: 7,2,1,8,3,19,9,5
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(7, 8, 9));
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
        ArrayList<Integer> d = new ArrayList<Integer>(Arrays.asList(1, 19));
        List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>(Arrays.asList(a.iterator(), b.iterator(), c.iterator(), d.iterator()));
        RotateIterator<Integer> rotateIterator = new RotateIterator<Integer>(list.iterator());
        while (rotateIterator.hasNext()) {
            System. out.print(rotateIterator.next() + "," );
        }
        System. out.println();
    }
}


class RotateIterator<E> implements Iterator<E> {
    private Iterator<Iterator<E>> it ;
    private List<Iterator<E>> lists ;
    private int pos ;

    public RotateIterator(Iterator<Iterator<E>> it) {
        this.it = it;
        pos = 0;
        this.lists = new LinkedList<Iterator<E>>();
        iteratorToList();
    }

    public boolean hasNext() {
        for (int i = pos ; i < lists.size(); i++) {
            if (lists .get(pos ).hasNext()) {
                return true ;
            }
            pos = ( pos + 1) % lists.size();
        }
        return false ;
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E val = lists.get( pos).next();
        pos = ( pos + 1) % lists.size();
        return val;
    }

    private void iteratorToList() {
        while (it .hasNext()) {
            lists.add( it.next());
        }
    }

    public void remove() {

    }
}
