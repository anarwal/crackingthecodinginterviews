package general;

import java.util.Scanner;

public class MaxSubArrayProduct {
    public static int maxProduct(int[] nums) {
        if(nums.length ==0) return -1;

        int curMax =nums[0];
        int curMin =nums[0];
        int mul    =nums[0];
        for(int i=1; i<nums.length; i++){
            int temp = curMax;
            curMax = Math.max(Math.max(curMax*nums[i], curMin*nums[i]), nums[i]);
            curMin = Math.min(Math.min(temp*nums[i], curMin*nums[i]), nums[i]);
            if(curMax > mul)
                mul = curMax;
        }
        return mul;
    }

    public static void main(String[] args){
        int m =0;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0; i<m; i++){
            arr[i]= sc.nextInt();
        }
        System.out.print(maxProduct(arr));

    }
}
