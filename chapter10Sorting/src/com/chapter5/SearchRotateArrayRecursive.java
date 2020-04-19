package com.chapter5;

import java.util.Arrays;
import java.util.Scanner;

class SearchRotateArrayRecursive {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right=nums.length-1;
        int pivot =findPivot(nums, left, right);

        if(pivot == -1){
            return binarySearch(nums, left, right, target);
        }

        if(nums[pivot] ==target) return pivot;

        if(nums[0]<=target) return binarySearch(nums, 0, pivot-1, target);

        return binarySearch(nums, pivot+1, right, target);
    }

    static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        int mid = (low + high)/2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid + 1, high);
    }

    public static int binarySearch(int[] nums, int left, int right, int target){
        if(right >=left){
            int mid = (left+right)/2;
            if(target == nums[mid]) return mid;
            if(target<nums[mid]) return binarySearch(nums,left, mid-1, target);
            return binarySearch(nums,mid+1, right, target);
        }
        else return -1;
    }

    public static void main(String[] args) {
        int m, n = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] =scanner.nextInt();
        }
        n = scanner.nextInt();
        int result = search(arr, n);
        System.out.print(result);
        scanner.close();
    }
}
