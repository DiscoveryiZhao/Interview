package DataStructure.Iterator;

import java.util.Iterator;

/**
 * Created by YZ on 8/23/15.
 */
public class CircularArrayclassanditsIterator {
    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<String>(size);
        // array[] = {0,1,2,3,4,5,6,7,8,9},
        for (int i = 0; i < size; i++) {
            array.set(i, Integer. toString(i));
        }

        array.rotate(3);
        // 3,4,5,6,7,8,9,0,1,2,
        for (int i = 0; i < size; i++) {
            System. out.print(array.get(i) + "," );
        }

        System. out.println("" );

        array.rotate(2);
        // 5,6,7,8,9,0,1,2,3,4,
        for (String s : array) {
            System. out.print(s + "," );
        }
    }


}
 class CircularArray<E> implements Iterable<E> {
    private E[] circularBuffer ;
    private int pos = 0;

    public CircularArray(int size) {
        circularBuffer = (E[]) new Object[size] ;
    }

    public void set(int i, E item) {
        circularBuffer[(pos + i) % circularBuffer .length ] = item;
    }

    public E get(int i) {
        return circularBuffer [(pos + i) % circularBuffer .length ];
    }

    public void rotate(int shiftRight) {
        pos = ( pos + shiftRight) % circularBuffer.length ;;
    }

    public Iterator<E> iterator() {
        return new CircularArrayIterator<E>(this);
    }

    // Implementing the Iterator Interface
    private class CircularArrayIterator<E > implements Iterator<E> {
        private E[] circularBuffer ;
        private int posIT = 0;

        public CircularArrayIterator(CircularArray<E> circularArray) {
            circularBuffer = circularArray.circularBuffer ;
        }

        @Override
        public boolean hasNext() {
            return posIT < circularBuffer .length ;
        }

        @Override
        public E next() {
            E item = (E) circularBuffer[(pos + posIT ) % circularBuffer.length ];
            posIT++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}