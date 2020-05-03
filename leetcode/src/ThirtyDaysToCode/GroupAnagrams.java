package ThirtyDaysToCode;

import java.util.*;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] arrayStr = strs[i].toCharArray();
            Arrays.sort(arrayStr);
            String sortedString = new String(arrayStr);

            if(!hmap.containsKey(sortedString)){
                hmap.put(sortedString,new ArrayList<>());
            }
            hmap.get(sortedString).add(strs[i]);
        }
        return new ArrayList(hmap.values());
    }
}
