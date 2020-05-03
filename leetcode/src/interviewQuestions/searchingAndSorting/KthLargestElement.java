package interviewQuestions.searchingAndSorting;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for( int i: nums){
            minheap.add(nums[i]);
            if(minheap.size() > k){
                minheap.poll();
            }
        }
        return minheap.poll();
    }
}
