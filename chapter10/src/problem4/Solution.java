package problem4;

/**
 * Created by abhimanyunarwal on 2/26/17.
 * Sorted Search, No  Size: You are given an array-like data structure Listy which lacks a size method. It does, however,
 * have an elementAt(i) method  that returns the element at index i in O(1) time. If i is beyond the bounds of the data structure,
 * it returns -1. (For this reason, the data structure only supports positive integers). Given a Listy which contains sorted, positive
 * integers, find the index at which an element x occurs. If x occurs multiple times, you may return any index.
 */

public class Solution {

   //Just a skeleton
  class Listy {
      public int elementAt(int elem) {
          return elem;
      }
  }
  public static void findElementIndex(Listy list, int element){
   int index=1;
   while(list.elementAt(index) != -1 && list.elementAt(index)<element){
     index *= 2;
   }
   binarySearch(list, element, index/2, index);
  }

  public static int binarySearch(Listy list, int value, int left, int right){
    int middle=(left+right)/2;
    int mid=list.elementAt(middle);
    if(mid>value || mid ==-1){
      right=mid-1;
    }else if(mid<value){
        left=mid-1;
    }else{
      return mid;
    }
    return -1;
    }
}


