package thirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/

public class SingleNumberInArray {
    public int singleNumber(int[] nums) {
        int xor_result = nums[0];
        for(int i=1; i<nums.length; i++){
            xor_result = xor_result ^ nums[i];
        }
        return xor_result;
    }
}
