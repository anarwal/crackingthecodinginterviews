package thirtyDaysToCode;

import java.util.Arrays;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        while(n >1) {
            int diff = stones[n - 1] - stones[n - 2];
            stones[n - 2] =diff;
            n = n - 1;
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
