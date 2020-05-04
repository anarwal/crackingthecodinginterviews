package bloomberg.arrays;

import java.util.Scanner;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;

        int finalIndex = m+n-1;

        while(index2>=0 && index1>=0 ){
            if(nums1[index1]>nums2[index2]){
                nums1[finalIndex] = nums1[index1];
                index1--;
            }else{
                nums1[finalIndex] = nums2[index2];
                index2--;
            }
            finalIndex--;
        }

        System.arraycopy(nums2, 0, nums1, 0,  index2 + 1);
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
        merge(A, 3, B, m);
    }


}
