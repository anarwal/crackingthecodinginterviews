package thirtyDaysToCode;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/

public class HappyNumber {
    public static int sqSum(int n){
        int newNum=0;
        while (n>0){
            newNum += Math.pow(n%10, 2);
            n = n/10;
        }
        return newNum;
    }

    public static boolean isHappy(int n) {
        //to store pre-computed results to avoid looping
        List<Integer> alist = new ArrayList<>();
        while(n>1 && !(alist.contains(n))){
            alist.add(n);
            n = sqSum(n);
        }
        return n==1;
    }
}
