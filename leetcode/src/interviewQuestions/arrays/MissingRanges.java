package interviewQuestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> aList = new ArrayList<>();
        if(nums.length == 0)
        {
            aList.add(getRange(((long)lower-1),((long)upper+1)));
        }
        else{

            if(lower < nums[0])
                aList.add( getRange(((long)lower-1), nums[0]));

            for(int index = 1; index < nums.length; index++){
                int left = nums[index-1];
                int right = nums[index];
                if(left==right) continue;
                if( ((long)left+1) != right){
                    aList.add(getRange(left, right));
                }
            }
            if(nums[nums.length-1] < upper)
                aList.add(getRange(nums[nums.length-1], ((long)upper+1)));
        }


        return aList;
    }

    private String getRange(long left, long right){
        int start =(int) left+1;
        int end = (int)right-1;

        if(start == end){
            return String.valueOf(start);
        }else{
            return String.valueOf(start) + "->" + String.valueOf(end);
        }
    }
}
