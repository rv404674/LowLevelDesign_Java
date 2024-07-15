package InMemoryCache.storage;

public interface IStorage {
    String get(String key);

    void put(String key, String value);

    int getSize();

    void delete(String key);

    boolean isContains(String key);
}
