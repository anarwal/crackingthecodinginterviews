package problem5;

/**
 * Created by abhimanyunarwal on 2/26/17.
 * Sparse Search: Given a sorted array of string that is interspersed with empty strings, write a
 * method to find the location of a given string.
 * Example:
 * Input: ball, {"at","","","","ball","","","car","","","car","","","dad","",""}
 * Output: 4
 */
public class Solution {

  public static int findString(String[] array, String str, int left, int right){
    if(left>right){
      return -1;
    }
    int middle=(left+right)/2;

    //the above will work if middle is not empty, but in the case it is empty, you will have to shift left or right
    if(array[middle].isEmpty()){
      int l=middle-1;
      int r=middle+1;
      while(true){
        if(l<left && r< right){
          return -1;
        }
        else if(r <=right && !array[r].isEmpty()){
          middle=right;
          break;
        } else if( l >= left && !array[l].isEmpty()){
          middle = left;
          break;
        }
        r++;
        l++;
      }
    }

    if(str.equals(array[middle])){
      return middle;
    }else if(array[middle].compareTo(str) <0){
      return findString(array, str, middle+1, right);
    }else{
      return findString(array, str, left, middle-1);
    }
  }


  public static int search(String[] string, String str){
    if(string == null || str == null || str== ""){
      return -1;
    }
    return findString(string, str, 0, string.length-1);
  }

}
