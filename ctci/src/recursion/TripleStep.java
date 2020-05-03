package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/7/17.
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time.
 * Implement a method to count how many possible ways the child run up the stairs
 */
public class TripleStep {


    public static int possibleWays(int n){
        if(n<0){
            return 0;
        }else if(n==0){
            return 1;
        }
        else{
            return possibleWays(n-1)+possibleWays(n-2)+possibleWays(n-3);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        possibleWays(n);

    }


    //Approach 2
    public int countWays(int n){
        int[] memo=new int[n+1];
        Arrays.fill(memo, -1);
        return countingWays(n, memo);
    }

    public int countingWays(int n, int[] memo){
        if(n<0){
            return 0;
        }else if(n==0){
            return 1;
        }else if(memo[n]>-1){
            return memo[n];
        }else {
            memo[n]=countingWays(n-1, memo) +countingWays(n-2, memo)+ countingWays(n-3, memo);
            return memo[n];
        }
    }
}
