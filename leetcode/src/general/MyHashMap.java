package general;

import java.util.Arrays;

class MyHashMap {
    int[] hashArray;

    public MyHashMap() {
        hashArray = new int[1000001];
        Arrays.fill(hashArray, -1);
    }

    /** Initialize your data structure here. */
    public void put(int key, int value) {
        hashArray[key] =value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashArray[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashArray[key] =-1;
    }
}
