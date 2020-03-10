package problem9;

/**
 * Created by abhimanyunarwal on 2/27/17.
 Sorted Matrix Search: Given an MXN matrix, in which each row and each column is sorted in ascending order,
 write a method to find an element.
 */
public class SortedMatrixSearch {

  public static boolean findElement (int[][] matrix, int element){
    int row=matrix[0].length-1;
    int col=0;
    while(row>=0 && col <matrix.length){
      if(matrix[row][col]==element){
        return true;
      }else if(matrix[row][col]<element){
        col++;
      }else{
          row--;
      }
    }
    return false;
  }


}
