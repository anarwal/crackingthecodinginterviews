package sorting;

class SearchRotateArrayIterative{
	static int searchElementinRotateArray(int[] nums, int target){
		int left =0;
		int right=nums.length-1;

		while(left<right){
			int mid = (left+right)/2;
			if(nums[mid]==target) return mid;
			else if(nums[mid]>nums[left]){  // left part is sorted
				if(target<nums[mid] && nums[left]<nums[mid]) right = mid-1;
				else left= mid+1;
			}else{ //right part is sorted
				if(target>nums[mid] && nums[mid]<nums[right]) left = mid+1;
				else right = mid -1;
			}

		}
		return -1;
	}

}
