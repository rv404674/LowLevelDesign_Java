package BookingSystemForBuses.storage;

//public interface IStorage {
//    Booking get(String key);
//
//    void write(String key, Booking booking);
//}

public interface IStorage<K, V> {
    V get(K key);

    void write(K key, V value);
}
