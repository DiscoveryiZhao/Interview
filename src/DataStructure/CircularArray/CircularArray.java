package DataStructure.CircularArray;

import java.util.Iterator;

/**
 * Created by YZ on 8/27/15.
 */
public class CircularArray<E> implements Iterable<E> {
    private E[] circularBuffer;
    private int pos = 0;

    public CircularArray(int size) {
        circularBuffer = (E[]) new Object[size];
    }

    public void set(int i, E item) {
        circularBuffer[(pos + i) % circularBuffer.length] = item;
    }

    public E get(int i) {
        return circularBuffer[(pos + i) % circularBuffer.length];
    }

    public void rotate(int shiftRight) {
        pos = (pos + shiftRight) % circularBuffer.length;
        ;
    }

    public Iterator<E> iterator() {
        return new CircularArrayIterator<E>(this);
    }

    // Implementing the Iterator Interface
    private class CircularArrayIterator<E> implements Iterator<E> {
        private E[] circularBuffer;
        private int posIT = 0;

        public CircularArrayIterator(CircularArray<E> circularArray) {
            circularBuffer = circularArray.circularBuffer;
        }

        @Override
        public boolean hasNext() {
            return posIT < circularBuffer.length;
        }

        @Override
        public E next() {
            E item = (E) circularBuffer[(pos + posIT) % circularBuffer.length];
            posIT++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}