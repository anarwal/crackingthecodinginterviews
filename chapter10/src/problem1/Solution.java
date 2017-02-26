package problem1;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 2/26/17.
 * Sorted Arrays: You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
public class Solution {

    /*
    First Approach: While copying, iterate and then shift array A based on where the elements gets placed from array B
    Second Approach: Copy all elements from array B in array A and then sort resulting array
    Third Approach: While copying compare last elements from both A and B, place the elements accordingly then
    Third Approach is the most optimal one in this, as then we do not spend extra memory and time
     */

    public static int[] mergeArrays(int[] A, int[] B){
        System.arraycopy(A, A[A.length-1], B, B[0],B.length-1);
        merge(A, new int[A.length-1], 0, A.length-1);
        return A;
    }

    public static void merge(int[] arr, int[] temp, int left, int right){
        if(left==right){return;}

        int middle=(left+right)/2;

        merge(arr, temp, left, middle);
        merge(arr, temp, middle+1, right);
        sort(arr, temp, left,middle, right);
    }

    public static void sort(int[] a, int[] temp, int left, int middle, int right){

        //copy all elements of array in helper array
        for(int i=left; i<=right; i++){
            temp[i]=a[i];
        }

        int index=left;
        int l=left;
        int r=middle+1;

        while(l<=middle && r<=right){
            if(temp[l]<=temp[r]){
                a[index]=temp[l];
                l++;
            }else{
                a[index]=temp[r];
                r++;
            }
            index++;
        }

        //copy the remaining elements
        while(l <= middle){
            a[index] = temp[l];
            index++;
            l++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int m= scan.nextInt();
        int[] A=new int[n];
        for(int i=0; i<A.length;i++){
            A[i]=scan.nextInt();
        }
        int[] B= new int[m];
        for(int j=0; j<B.length;j++){
            B[j]=scan.nextInt();
        }
        System.out.println(mergeArrays(A, B));
    }


}
