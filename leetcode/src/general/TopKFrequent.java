package general;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i], hmap.get(nums[i])+1);
            }else{
                hmap.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (w1, w2) -> hmap.get(w2)-hmap.get(w1));
        for(Integer i: hmap.keySet()){
            pq.offer(i);
        }
        int j=0;
        while(k>0){
            result[j] = pq.remove();
            j++;
            k--;
        }

        return result;

    }
}
