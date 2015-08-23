package DataStructure.Iterator;

import java.util.*;

/**
 * Created by YZ on 8/23/15.
 */
public class ArrayIntListIteratorMain {
    public static void main(String[] args) {
        // 输入: [1,2,3,4,5]
        // 输出: 1,2,3,4,5
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayIntListIterator<Integer> iter = new ArrayIntListIterator<Integer>(al);
        while (iter.hasNext()) {
            System. out.print(iter.next() + "," );
            iter.remove();
        }

        // 输出: []
        System. out.println(al);
    }
}

class ArrayIntListIterator<E> implements Iterator<E> {
    private List<E> list ; // list to iterate over
    private int pos ; // current position within the list
    private boolean removeOK ; // whether it's okay to remove now

    public ArrayIntListIterator(List<E> list) {
        this.list = list;
        pos = 0;
        removeOK = false;
    }

    // returns true if there are more elements to be examined
    public boolean hasNext() {
        return pos < list .size();
    }

    // returns the next element from the list and advances the position of the iterator by one
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E e = (E) list.get( pos++);
        removeOK = true;
        return e;
    }

    // removes the element most recently returned by next()
    public void remove() {
        if (!removeOK ) {
            throw new IllegalStateException();
        }
        list.remove(-- pos);
        removeOK = false;
    }
}