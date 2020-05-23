package topSeventyFive.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            HashMap<Integer, Integer> hmap = new HashMap<>();

            for(int i=0; i<nums.length; i++){
                    hmap.put(nums[i], i);
            }

            for(int i =0; i<nums.length; i++){
                int comp = target - nums[i];
                if(hmap.containsKey(comp) && hmap.get(comp) !=i){
                    result[0] = i;
                    result[1] = hmap.get(comp);
                }
            }
            return result;
    }

    public static void main(String[] main){
            int m, n = 0;
            Scanner scanner = new Scanner(System.in);
            m = scanner.nextInt();
            n = scanner.nextInt();
            int arr[] = new int[m];
            for(int i = 0; i < m; i++) {
                arr[i] =scanner.nextInt();
            }
            twoSum(arr, n);
            scanner.close();
    }
}
