package ThirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
