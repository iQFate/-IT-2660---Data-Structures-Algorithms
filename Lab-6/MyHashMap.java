//**Step 2:** Complete MyHashMap.java using LiveExample 27.2.
import java.util.*;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private LinkedList<MyMap.Entry<K, V>>[] table;
    private int size = 0;
    private int capacity;
    private float loadFactorThreshold;

    public MyHashMap() {
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.loadFactorThreshold = DEFAULT_MAX_LOAD_FACTOR;
        table = new LinkedList[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void clear() {
        size = 0;
        table = new LinkedList[capacity];
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<MyMap.Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (MyMap.Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            LinkedList<MyMap.Entry<K, V>> bucket = table[i];
            if (bucket != null) {
                for (MyMap.Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) return true;
                }
            }
        }
        return false;
    }

    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            LinkedList<MyMap.Entry<K, V>> bucket = table[i];
            if (bucket != null) {
                set.addAll(bucket);
            }
        }
        return set;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<MyMap.Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            for (MyMap.Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) return entry.getValue();
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (MyMap.Entry<K, V> entry : entrySet()) {
            keys.add(entry.getKey());
        }
        return keys;
    }

    public V put(K key, V value) {
        if ((float)(size + 1) / capacity > loadFactorThreshold) {
            rehash();
        }

        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (MyMap.Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.value = value;
                return oldValue;
            }
        }

        table[index].add(new MyMap.Entry<>(key, value));
        size++;
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<MyMap.Entry<K, V>> bucket = table[index];
        if (bucket != null) {
            Iterator<MyMap.Entry<K, V>> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getKey().equals(key)) {
                    iterator.remove();
                    size--;
                    break;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public Set<V> values() {
        Set<V> values = new HashSet<>();
        for (MyMap.Entry<K, V> entry : entrySet()) {
            values.add(entry.getValue());
        }
        return values;
    }

    private void rehash() {
        Set<MyMap.Entry<K, V>> oldEntries = entrySet();
        capacity *= 2;
        size = 0;
        table = new LinkedList[capacity];

        for (MyMap.Entry<K, V> entry : oldEntries) {
            put(entry.getKey(), entry.getValue());
        }
    }
}