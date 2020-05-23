package topSeventyFive.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if(nums ==null || nums.length ==0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int counter=0;
        for(int i=0; i<nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                counter = Math.max(counter, dp[i]);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i =0; i<m;i++){
            arr[i] = scanner.nextInt();
        }
        int result = lengthOfLIS(arr);
        System.out.println(result);
        scanner.close();
    }
}
