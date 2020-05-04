package thirtyDaysToCode;

import java.util.Scanner;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int maxPossible = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            maxPossible = Math.max(maxPossible, i + nums[i]);
            if(maxPossible >= nums.length - 1 || maxPossible == i)
                break;
        }
        return maxPossible >= nums.length - 1;
    }

    public static void main(String[] args) {
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
                arr[i] =scanner.nextInt();
        }
        boolean result = canJump(arr);
        System.out.println(result);
        scanner.close();
    }
}
