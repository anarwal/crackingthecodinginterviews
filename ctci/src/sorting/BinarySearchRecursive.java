package sorting;

class BinarySearchRecursive{
	public static int binarySearch(int[] nums, int left, int right, int target){
        if(right >=left){
            int mid = (left+right)/2;
            if(target == nums[mid]) return mid;
            if(target<nums[mid]) return binarySearch(nums,left, mid-1, target);
            return binarySearch(nums,mid+1, right, target);
        }
        else return -1;
    }
}
