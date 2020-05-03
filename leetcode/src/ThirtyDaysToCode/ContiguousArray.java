package ThirtyDaysToCode;

import java.util.HashMap;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int lenone = 0 , lenzero = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lenzero++;
            } else {
                lenone++;
            }
            if (hmap.containsKey(lenzero - lenone)) {
                maxLen = Math.max(maxLen, i - hmap.get(lenzero - lenone));
            } else {
                hmap.put(lenzero - lenone, i);
            }
        }
        return maxLen;
    }
}
