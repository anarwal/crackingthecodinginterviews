package interviewQuestions.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int freq = nums.length / 2;
        int result = 0;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i< nums.length; i++) {
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }else{
                hmap.put(nums[i], 1);
            }

        }
        for (Map.Entry me : hmap.entrySet()) {
            if ((int) me.getValue() > freq) {
                result = (int) me.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
                arr[i] =scanner.nextInt();
        }
        System.out.print(majorityElement(arr));
        scanner.close();
    }
}
