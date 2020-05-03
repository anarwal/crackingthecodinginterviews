package ThirtyDaysToCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

        Map<Integer, Integer> lmap;
        int capacity;

        public LRUCache(int capacity) {
            this.lmap = new LinkedHashMap<Integer, Integer>(capacity);
            this.capacity = capacity;
        }

    public int get(int key) {
        // if exists
        if(lmap.containsKey(key)){
            //remove from cache as recently accessed
            int val = lmap.remove(key);
            //add to the front of cache to update recent use
            lmap.put(key, val);
            return val;
        }else{ //if doesnt exist return -1
            return -1;
        }
    }

        public void put(int key, int value) {
            // if already exisiting in the cache
            if(lmap.containsKey(key)){
                //first remove from cache
                lmap.remove(key);
            }

            //if the capacity full, remove least recently used
            if(lmap.size() == capacity){
                int lru = lmap.entrySet().iterator().next().getKey();
                lmap.remove(lru);
            }
            // else directly add
            lmap.put(key, value);
        }
}
