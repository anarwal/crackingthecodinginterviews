package problem2;

import java.util.*;

/**
 * Created by abhimanyunarwal on 2/26/17.
 * Group Anagrams: Write method to sort an array of strings so that all the anagrams are next to each other
 */

public class GroupAnagrams {

  public static void sortAnagrams(String[] arr){
    /*
    Sample input: {abc, bca, fgh, ar, ku, hgf};
    Sample output: {{abc, bca},{fgh,hgf},{ar},{ku}}
    */

    //Take a list for group of strings which are anagrams
    List<List<String>> list = new ArrayList<>();

    //Use Hashmap, to store a character sequence as key, and anagrams as value in a arraylist
    Map<String, ArrayList<String>> map= new HashMap<>();
    for(String str : arr){
      char[] a =new char[26];

      //for every string, take out characters and increment their count
      for(int i=0; i<str.length(); i++){
        a[str.charAt(i)]++;
      }

      //next take the string and add to map, if its character sequence is already there
      String s=new String(a);
      if(map.containsKey(s)){
        map.get(s).add(str);
      }else{
        //if not place character sequence as key and corresponding string in list to map
        ArrayList<String> aList= new ArrayList<String>();
        aList.add(str);
        map.put(s, aList);
      }
    }
    //lastly add all the map values to a list
    list.addAll(map.values());
  }

  public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    int n=scan.nextInt();
    String[] arr=new String[n];
    for(int i=0; i<arr.length;i++){
      arr[i]=scan.next();
    }
  }
}
