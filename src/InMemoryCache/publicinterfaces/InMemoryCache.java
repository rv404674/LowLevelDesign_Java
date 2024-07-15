package InMemoryCache.publicinterfaces;

import InMemoryCache.eviction.IEvictionPolicy;
import InMemoryCache.storage.IStorage;

public class InMemoryCache {
    IEvictionPolicy evictionPolicy;
    IStorage storage;
    int cacheCapacity;

    public InMemoryCache(int cacheCapacity, IEvictionPolicy evictionPolicy, IStorage storage) {
        this.cacheCapacity = cacheCapacity;
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public String get(String key) {
        if (storage.get(key) == null) {
            return "";
        }

        evictionPolicy.moveToTheFront(key);
        return storage.get(key);
    }

    public void put(String key, String value) {
        // cap full
        if (storage.getSize() == cacheCapacity) {
            String evictedKey = evictionPolicy.evict();
            storage.delete(evictedKey);

            evictionPolicy.moveToTheFront(key);
            storage.put(key, value);
            return;
        }

        // already exists
        if (storage.isContains(key)) {
            evictionPolicy.moveToTheFront(key);
            storage.put(key, value);
            return;
        }

        // first time
        evictionPolicy.moveToTheFront(key);
        this.storage.put(key, value);
    }
}
