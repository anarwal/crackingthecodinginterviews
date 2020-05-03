package interviewQuestions.searchingAndSorting;

import java.util.Arrays;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){ return 0; }
        int[] sortedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArray);
        int len = sortedArray.length-1;

        while(len>0){
            for(int i=0; i<nums.length; i++){
                if(nums[i] == sortedArray[len]){
                    if(i == 0 && nums[i+1]<sortedArray[len]){
                        return i;
                    }
                    if(i == nums.length-1  && nums[i-1]<sortedArray[len]){
                        return i;
                    }
                    if(i!=0 && i!= nums.length-1 && nums[i-1]<sortedArray[len] && nums[i+1] < sortedArray[len]){
                        return i;
                    }
                }
            }
            len--;
        }
        return -1;
    }
}
