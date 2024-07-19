package InMemoryCache.publicinterfaces;

import InMemoryCache.eviction.IEvictionPolicy;
import InMemoryCache.storage.IStorage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryCache {
    IEvictionPolicy evictionPolicy;
    IStorage storage;
    Lock lock;
    int cacheCapacity;

    public InMemoryCache(int cacheCapacity, IEvictionPolicy evictionPolicy, IStorage storage) {
        this.cacheCapacity = cacheCapacity;
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
        this.lock = new ReentrantLock(true);
    }

    public String get(String key) {
        lock.lock();

        try {
            if (storage.get(key) == null) {
                return "";
            }

            evictionPolicy.access(key);
            return storage.get(key);
        } finally {
            lock.unlock();
        }

    }

    public void put(String key, String value) {
        lock.lock();

        try {
            // cap full
            if (storage.getSize() == cacheCapacity) {
                String evictedKey = evictionPolicy.evict();
                storage.delete(evictedKey);

                evictionPolicy.access(key);
                storage.put(key, value);
                return;
            }

            // already exists or first time.
            evictionPolicy.access(key);
            storage.put(key, value);
        } finally {
            lock.unlock();
        }

    }
}
