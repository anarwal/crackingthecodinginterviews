package general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindNumberOfEvenDigits {
    public static int findNumbers(int[] nums) {
        int counter =0;
        int runningcounter=0;
        for(int i=0; i<nums.length; i++){
            while(nums[i]!=0){
                runningcounter++;
                nums[i] = nums[i]/10;
            }
            if(runningcounter%2==0){
                counter++;
            }
            runningcounter=0;
        }
        return counter;
    }

    public static void main(String[] args){
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        findNumbers(arr);
        scanner.close();
    }
}
