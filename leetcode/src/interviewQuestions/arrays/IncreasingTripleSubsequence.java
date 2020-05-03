package interviewQuestions.arrays;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/781/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncreasingTripleSubsequence {
    public boolean increasingTriplet(int[] nums) {

        if(nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < first) {
                first = nums[i];
            }

            if(nums[i] > first) {
                second = Math.min(second, nums[i]);
            }

            if(nums[i] > second) {
                return true;
            }
        }

        return false;
    }
}
