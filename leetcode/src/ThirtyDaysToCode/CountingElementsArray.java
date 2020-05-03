package ThirtyDaysToCode;

import java.util.HashMap;
import java.util.Map;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
public class CountingElementsArray {
    public static int countElements(int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0)+1);
        }
        int counter=0;
        for(Map.Entry me : hmap.entrySet()){
            while (hmap.containsKey((int) me.getKey() + 1) && (int)me.getValue()>0) {
                counter++;
                hmap.replace((int)me.getKey(),(int)me.getValue()-1);
            }
        }
        return counter;
    }
}
