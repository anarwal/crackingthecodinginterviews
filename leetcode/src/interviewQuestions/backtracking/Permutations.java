package interviewQuestions.backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem: Given a collection of distinct integers, return all possible permutations.
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if(nums.length == 0 || nums == null) return answer;
        List<Integer> innerlist = new ArrayList<>();
        boolean[] inuse = new boolean[nums.length];
        backtrack(nums, answer, inuse, innerlist);
        return answer;
    }

    void backtrack(int[] nums,List<List<Integer>> answer, boolean[] inuse, List<Integer> currentpermutation){
        if(currentpermutation.size() == nums.length){
            answer.add(new ArrayList<>(currentpermutation));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(inuse[i]) continue;
            inuse[i] = true;
            currentpermutation.add(nums[i]);
            backtrack(nums, answer, inuse, currentpermutation);
            currentpermutation.remove(currentpermutation.size()-1);
            inuse[i] = false;
        }
    }
}


