package DataStructure.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by YZ on 8/23/15.
 */
public class SkipIteratorMain {
    public static void main(String[] args) {
        // 输入: [1,2,3,4,5]
        // 输出: 1,3,5
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        SkipIterator<Integer> skipIterator = new SkipIterator<Integer>(al.iterator());
        while (skipIterator.hasNext()) {
            System. out.print(skipIterator.next() + "," );
        }
    }
}

class SkipIterator<E> implements Iterator<E> {
    private Iterator<E> iter ;

    public SkipIterator(Iterator<E> iter) {
        this.iter = iter;
    }

    public boolean hasNext() {
        return iter .hasNext();
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E e = iter.next();
        // skip next element
        if (iter .hasNext()) {
            iter.next();
        }
        return e;
    }

    public void remove() {
    }
}