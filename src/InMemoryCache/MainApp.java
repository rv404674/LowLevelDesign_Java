package InMemoryCache;

import InMemoryCache.eviction.IEvictionPolicy;
import InMemoryCache.eviction.LRUEviction;
import InMemoryCache.publicinterfaces.InMemoryCache;
import InMemoryCache.storage.HashMapStorage;
import InMemoryCache.storage.IStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException {
        // LEFT
        // 1. add reading from the io (use cpt buffered reader)
        // 2. Test all cases thoroughlty.
        // intialize 10
        // get rahul
        // set sachin verma

        InMemoryCache inMemoryCache = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] arrayStr = reader.readLine().trim().split(" ");

            if (arrayStr[0].equals("initialize")) {
                int capacity = Integer.parseInt(arrayStr[1]);
                IEvictionPolicy evictionPolicy = new LRUEviction();
                IStorage storage = new HashMapStorage();

                inMemoryCache = new InMemoryCache(capacity, evictionPolicy, storage);
            } else if (arrayStr[0].equals("get")) {
                String key = arrayStr[1];
                String val = inMemoryCache.get(key);
                if (val.isEmpty()) {
                    System.out.println("Key doesnt exist");
                } else {
                    System.out.println("Key = " + key + " Val = " + val);
                }
            } else {
                inMemoryCache.put(arrayStr[1], arrayStr[2]);
            }
        }

    }
}
