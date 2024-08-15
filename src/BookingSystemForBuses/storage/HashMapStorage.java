package BookingSystemForBuses.storage;

import java.util.HashMap;

public class HashMapStorage<K, V> implements IStorage<K, V> {
    HashMap<K, V> hashMap;

    public HashMapStorage() {
        hashMap = new HashMap<>();
    }

    @Override
    public V get(K key) {
        return this.hashMap.get(key);
    }

    @Override
    public void write(K key, V value) {
        this.hashMap.put(key, value);
    }
}
