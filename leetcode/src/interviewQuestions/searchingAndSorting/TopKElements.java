package interviewQuestions.searchingAndSorting;

import java.util.*;
// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/799/
public class TopKElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(hmap.containsKey(nums[i]))
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Integer> alist = new ArrayList<>();
        while(k>0){
            int i = Collections.max(hmap.entrySet(), Map.Entry.comparingByValue()).getKey();
            alist.add(i);
            hmap.remove(i);
            k--;
        }

        return alist;
    }

}
