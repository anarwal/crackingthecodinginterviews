package interviewQuestions.searchingAndSorting;

public class searchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        int leftindex = binarSearch(nums, target, true);

        //means not found
        if(leftindex == nums.length || nums[leftindex] !=target){
            return result;
        }

        result[0] = leftindex;
        int rightindex = binarSearch(nums, target, false);
        result[1] = rightindex-1;

        return result;
    }

    public int binarSearch(int[] nums, int target, boolean leftindex){
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left +(right-left)/2;
            if(nums[mid] > target || (leftindex && nums[mid] == target)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
