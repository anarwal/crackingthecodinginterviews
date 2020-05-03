package interviewQuestions.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/796/
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        boolean[] using = new boolean[nums.length];
        backtrack(nums, answer, subset, using);
        return answer;
    }

    static void backtrack(int[] nums, List<List<Integer>> answer, List<Integer> subset, boolean[] using){
        if(subset.size() < nums.length){
            answer.add(subset);
        }
        for(int i=0; i<nums.length; i++){
            if(using[i]) continue;
            using[i] = true;
            subset.add(nums[i]);
            backtrack(nums, answer, subset, using);
            subset.remove(nums[i]);
            using[i] = false;
            while(i+1<nums.length && nums[i] == nums[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i =0; i<m;i++){
            arr[i] = scanner.nextInt();
        }
        List<List<Integer>> result = subsets(arr);
        for(List<Integer> i:result){
            System.out.println(i);
        }
        System.out.println(result);
        scanner.close();
    }
}
