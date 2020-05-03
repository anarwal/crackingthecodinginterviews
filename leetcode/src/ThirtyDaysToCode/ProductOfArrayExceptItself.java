package ThirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] =1;
        right[nums.length-1] = 1;

        for(int i = 1;i<nums.length;i++){
            left[i] = nums[i-1] * left[i-1];
        }

        for(int j = nums.length-2 ;j>=0;j--){
            right[j] = nums[j+1] * right[j+1];
        }

        for(int k=0; k<nums.length; k++){
            result[k] = left[k]*right[k];
        }
        return result;
    }
}
