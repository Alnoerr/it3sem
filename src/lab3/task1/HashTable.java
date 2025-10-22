package lab3.task1;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<K, V> {
    private final ArrayList<LinkedList<HashTableEntry<K, V>>> table;
    private final int capacity;
    private int size;

    public HashTable() {
        this.table = new ArrayList<>();
        this.capacity = 100;
        increaseInnerTableSizeTo(capacity);
    }

    public HashTable(int capacity) {
        this.table = new ArrayList<>();
        this.capacity = capacity;
        increaseInnerTableSizeTo(capacity);
    }

    public HashTable(int capacity, ArrayList<LinkedList<HashTableEntry<K, V>>> table) {
        this.table = table;
        this.capacity = capacity;
    }

    private void increaseInnerTableSizeTo(int targetSize) {
        while (table.size() < targetSize) table.add(new LinkedList<>());
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table.get(index) == null) {
            table.set(index, new LinkedList<>());
        }
        for (HashTableEntry<K, V> entry : table.get(index)) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table.get(index).add(new HashTableEntry<>(key, value));
        size++;
    }

    public LinkedList<HashTableEntry<K,V>> get(K key) {
        if (isEmpty()) return null;
        return table.get(hash(key));
    }

    public LinkedList<HashTableEntry<K, V>> remove(K key) {
        if (isEmpty()) return null;
        LinkedList<HashTableEntry<K, V>> removedItem = table.set(hash(key), new LinkedList<>());
        size -= removedItem.size();
        return removedItem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
