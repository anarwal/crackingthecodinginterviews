package general;

import javafx.util.Pair;

import java.util.*;

public class TimeBaseKeyValue {
    HashMap<String, TreeMap<Integer, String>> hmap;

    /** Initialize your data structure here. */
    public TimeBaseKeyValue() {
        hmap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!hmap.containsKey(key)){
            hmap.put(key, new TreeMap<Integer, String>());
        }
        hmap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!hmap.containsKey(key)) return "";
        TreeMap<Integer, String> tmap = hmap.get(key);
        Integer index = tmap.floorKey(timestamp);
        return index==null ? "":tmap.get(timestamp);
    }
}
