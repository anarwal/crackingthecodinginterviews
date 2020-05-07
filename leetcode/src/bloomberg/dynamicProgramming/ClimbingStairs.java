package bloomberg.dynamicProgramming;

public class ClimbingStairs {
    //dp
    public int climbStairs(int n) {
        if(n ==1 )return 1;
        int[] dp = new int[n+1];
        dp[1] =1;
        dp[2] =2;
        for(int i=3; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //brute
    public int climbStairsBrute(int n) {
        int steps =0;
        return totalSteps(steps, n);
    }

    int totalSteps(int step, int n){
        if(step>n) return 0;
        if(step == n) return 1;
        return totalSteps(step+1, n) + totalSteps(step+2, n);
    }
}
