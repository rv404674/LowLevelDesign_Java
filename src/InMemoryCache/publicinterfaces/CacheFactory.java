package InMemoryCache.publicinterfaces;

import InMemoryCache.eviction.IEvictionPolicy;
import InMemoryCache.eviction.LRUEviction;
import InMemoryCache.storage.HashMapStorage;
import InMemoryCache.storage.IStorage;

public class CacheFactory {
    public static InMemoryCache getCache(int capacity) {
        IEvictionPolicy evictionPolicy = new LRUEviction();
        IStorage storage = new HashMapStorage();

        return new InMemoryCache(
                capacity,
                evictionPolicy,
                storage
        );
    }
}
