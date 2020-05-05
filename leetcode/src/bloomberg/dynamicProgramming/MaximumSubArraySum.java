package bloomberg.dynamicProgramming;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
public class MaximumSubArraySum {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int maxSum = sum;
        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i],sum+nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}

