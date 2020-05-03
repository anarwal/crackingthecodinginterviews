package ThirtyDaysToCode;
// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3312/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0 ) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0; i<matrix.length; i++){
            dp[i][0]=0;
        }
        for(int j=0; j<matrix[0].length; j++){
            dp[0][j]=0;
        }
        int max = 0;
        for(int i=1; i<=matrix.length; i++){
            for(int j=1; j<=matrix[0].length; j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
