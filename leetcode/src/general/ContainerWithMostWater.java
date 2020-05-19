package general;

import java.util.Scanner;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right =height.length-1;
        int max=0;
        while(right>left){
            if(height[left]>height[right]) {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }else {
                max = Math.max(max, height[left] * (right - left));
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int m =0;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int[] arr =new int[m];

        for(int i=0; i<m; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxArea(arr));
        sc.close();
    }
}
