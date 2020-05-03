package interviewQuestions.searchingAndSorting;
// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/798/
public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0; //index for 0
        int curr = 0; //where you are in array
        int p2 = nums.length - 1; //index for 2

        int tmp; //to swap use this
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}
