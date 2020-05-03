package sorting;

import java.util.Scanner;

public class MergeSort {
    static int[] mergesort(int[] array){
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
        return array;
    }

    static void mergeSort(int[] array, int[] helper, int i, int j){
        if(i<j){
            int mid = (i+j)/2;
            mergeSort(array, helper, i, mid);
            mergeSort(array, helper, mid+1, j);
            merge(array,helper, i, j, mid);
        }
    }

    static void merge(int[] array, int[] helper, int left, int right, int middle){
        for(int i=left; i <= right; i++){
            helper[i] = array[i];
        }

        int lefthelper = left;
        int righthelper = middle+1;
        int current = left;

        while(lefthelper<=middle && righthelper<=right){
            if(helper[lefthelper]<=helper[righthelper]){
                array[current] = helper[lefthelper];
                lefthelper++;
            }else{
                array[current] = helper[righthelper];
                righthelper++;
            }
            current++;
        }

        int rem = middle-lefthelper;
        for(int i=0; i <=rem; i++) {
            array[current + i] = helper[lefthelper + i];
        }
    }

    public static void main(String[] args) {
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
                arr[i] =scanner.nextInt();
        }
        int[] result = mergesort(arr);

        for(int i = 0; i <result.length; i++){
            System.out.print(result[i]+",");
        }
        scanner.close();
    }
}
