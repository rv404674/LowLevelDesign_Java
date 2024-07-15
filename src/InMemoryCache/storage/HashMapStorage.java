package InMemoryCache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage implements IStorage {
    Map<String, String> hashMap;

    public HashMapStorage() {
        this.hashMap = new HashMap<>();
    }

    @Override
    public String get(String key) {
        return this.hashMap.get(key);
    }

    @Override
    public void put(String key, String value) {
        this.hashMap.put(key, value);
    }

    @Override
    public int getSize() {
        return this.hashMap.size();
    }

    @Override
    public void delete(String key) {
        this.hashMap.remove(key);
    }

    @Override
    public boolean isContains(String key) {
        return this.hashMap.containsKey(key);
    }
}
