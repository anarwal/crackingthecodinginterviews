package problem8;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhimanyunarwal on 2/27/17.
 * Find Duplicates: You have an array with all the numbers from 1 to N, where N is at most 32000. The array may have duplicate entries,
 * and you do not have to know what N is. With only 4 kilobytes of memory available, how would you print all duplicate elements in array?
 */
public class FindDuplicates {

  /*the question is tricky in terms of memory, I would first implement this with set, as set doesnt allow duplicates
   but then question can not be this easy as it says only 4kb of memory is available. solution given by book seems to
   be a good approach, where it is suggested to use BitSet vector
  */

    public static void findDuplicates(int[] arr){

      Set<Integer> unique = new HashSet<Integer>();

      for(int i=0; i<arr.length; i++){
        if(!unique.contains(arr[i])){
          unique.add(arr[i]);
        }else{
            System.out.println(arr[i] +" ");
        }
      }
    }


    //implementing approach using BitSet as suggested in book, I can also implement BitSet and finish this problem

    public static void checkDuplicates(int[] array){
        BitSet bitset = new BitSet(32000);
        for (int i = 0; i < array.length; i++){
            int num = array[i];
            if (bitset.get(num))
                System.out.print(num + " ");
            else
                bitset.set(num);
        }
    }
    
}
