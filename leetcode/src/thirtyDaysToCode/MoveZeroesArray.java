package thirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/

public class MoveZeroesArray {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] != 0){
                if(index !=i){
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}
