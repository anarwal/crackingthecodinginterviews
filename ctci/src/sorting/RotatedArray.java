package sorting;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by abhimanyunarwal on 2/26/17.
 * Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in array. You may assume that the array was originally sorted in increasing order.
 */

public class RotatedArray {

    //Using binary search, find if elemnt
    public static int binarySearch(int[] arr, int l,int r, int elem){
        int m=(l+r)/2;
        if(arr[m]==elem){return m;}
        //we will check if the left half is sorted, then look for element
        else if(arr[l]<arr[m]) {
            // we will try to find the element in left half
            if (elem >= arr[l] && elem <= arr[m]) {
                return binarySearch(arr, l, m - 1, elem);
            }
            //if we do not find, we will look in right half
            return binarySearch(arr, m + 1, r, elem);
        }
        //if left is not sorted then it means right half is sorted, so we look into the right half
        else  {
            //look in right half first for the element
            if(elem>=arr[m] && elem<=arr[r]){
                return binarySearch(arr, m+1, r, elem);
            }
            //if not in right half go and look in left half
            else{
                return binarySearch(arr, l, m-1, elem);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();
        int[] array=new int[n];
        for(int i=0; i<array.length;i++){
            array[i]=scan.nextInt();
        }
        int element= scan.nextInt();
        binarySearch(array, 0, array.length-1, element);
    }

}
