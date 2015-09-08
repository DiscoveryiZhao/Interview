package DataStructure.HashTable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by YZ on 8/27/15.
 */
public class MyHashTable<K, V> {
    List<Entry>[] table;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        table = new LinkedList[5];
    }

    public void put(K key, V val) {
        int i = hashCode(key);
        if (table[i] == null) {
            // creates a new LinkedList in the bucket
            table[i] = new LinkedList<>();
            table[i].add(new Entry(key, val));
        } else {
            List<Entry> list = table[i];
            for (Entry n : list) {
                if (n.key.equals(key)) {
                    // found duplicated key, replace its val then return
                    n.val = val;
                    return;
                }
            }

            // key doesn't exist in the list, creates a new node and add in the end of list
            list.add(new Entry(key, val));
        }
    }

    public V get(K key) {
        int i = hashCode(key);
        if (table[i] == null) {
            return null;
        }
        List<Entry> list = table[i];
        for (Entry n : list) {
            if (n.key.equals(key)) {
                return n.val;
            }
        }
        return null;
    }

    public int hashCode(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Entry inner class implementing the Entry with K type key and V type val.
    private class Entry {
        private K key;
        private V val;

        // Initialize a new Entry object of the given key and val.
        private Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}