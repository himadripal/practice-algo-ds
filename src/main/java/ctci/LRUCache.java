package ctci;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by Himadri Pal (mehimu@gmail.com) on 6/25/2017.
 */
public class LRUCache<K,V> {
    int capacity;
    LinkedHashMap<K,V> cache;

    public LRUCache(int capacity){
        cache = new LinkedHashMap<K, V>(capacity);
        this.capacity=capacity;
    }

    public void put(K key, V value){
        if(cache.size() >= capacity){
            Iterator it = cache.entrySet().iterator();
            it.next();
            it.remove();
        }
        cache.put(key,value);
    }
    public V get(K key){
        if(cache.size() > 0){
            V value = cache.get(key);
            if(cache.containsKey(key)){
                put(key,value);
            }
            return value;
        }
        return null;
    }

    public static void main(String[] args){
        LRUCache<String,String> cache = new LRUCache<>(3);
        cache.put("1","first");
        cache.put("2","second");
        cache.put("3","third");
        cache.put("4","fourth");
        System.out.println("1 = " +cache.get("1"));
        //.out.println("4 = " +cache.get("4"));
        System.out.println("2 = " +cache.get("2"));
        cache.put("1","first");
        System.out.println("3 = " +cache.get("3"));

    }
}
