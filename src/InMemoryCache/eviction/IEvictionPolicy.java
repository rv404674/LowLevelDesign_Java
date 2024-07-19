package InMemoryCache.eviction;

public interface IEvictionPolicy {

    // Evict the oldest entry.
    String evict();

    // Front has the most recent elements.
    void access(String key);

}
