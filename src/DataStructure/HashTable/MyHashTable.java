package DataStructure.HashTable;

import java.util.LinkedList;

/**
 * Created by YZ on 8/27/15.
 */
public class MyHashTable<K, V> {
    LinkedList<Node>[] table;

    @SuppressWarnings("unchecked" )
    public MyHashTable() {
        table = new LinkedList[5];
    }

    public int hashCodeOfKey(K key) {
        return Math.abs(key.hashCode()) % table. length;
    }

    public void put(K key, V val) {
        int i = hashCodeOfKey(key);
        if (table [i] == null) {
            // creates a new LinkedList in the bucket
            table[i] = new LinkedList<Node>();
            table[i].add( new Node(key, val));
        } else {
            LinkedList<Node> list = table[i];
            for (Node n : list) {
                if (n.key .equals(key)) {
                    // found duplicated key, replace its val then return
                    n. val = val;
                    return;
                }
            }

            // key doesn't exist in the list, creates a new node and add in the end of list
            list.add( new Node(key, val));
        }
    }

    public V get(K key) {
        int i = hashCodeOfKey(key);
        if (table [i] == null) {
            return null ;
        } else {
            LinkedList<Node> list = table[i];
            for (Node n : list) {
                if (n.key .equals(key)) {
                    return n.val ;
                }
            }
            return null ;
        }
    }

    // Node inner class implementing the Node with K type key and V type val.
    private class Node {
        private K key ;
        private V val ;

        // Initialize a new Node object of the given key and val.
        private Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}