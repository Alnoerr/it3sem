package lab3.task1;

import java.util.Map.Entry;
import java.util.Objects;

public class HashTableEntry<K, V> implements Entry<K, V> {
    private final K key;
    private V value;

    public HashTableEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    public String toString() {
        return "HashTableEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HashTableEntry<?, ?> other = (HashTableEntry<?, ?>) o;
        return this.key.equals(other.key) && this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
