package general;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> hmap;
    List<Integer> list;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!hmap.containsKey(val)){
            hmap.put(val, list.size());
            list.add(val);
            return true;
        }else return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hmap.containsKey(val)) return false;
        else{
            int index = hmap.get(val);
            int temp = list.get(list.size()-1);
            list.set(index, temp);
            hmap.put(temp, index);
            list.remove(list.size()-1);
            hmap.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
