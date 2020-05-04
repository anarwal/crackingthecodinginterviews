package thirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
public class BestTimeToBuyStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int maxPr = 0;
        for(int i=1; i<prices.length;i++){
            maxPr += Math.max(prices[i]-prices[i-1], 0);
        }

        return maxPr;
    }
}
