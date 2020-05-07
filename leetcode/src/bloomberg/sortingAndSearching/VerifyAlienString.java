package bloomberg.sortingAndSearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class VerifyAlienString {
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            hmap.put(order.charAt(i), i);
        }
        boolean result = false;
        for(int i=0; i<words.length-1; i++){
            result = wordsCompare(words[i], words[i+1], hmap);
            if(result == false) break;
            else continue;
        }
        return result;
    }

    static boolean wordsCompare(String s1, String s2, HashMap<Character, Integer> order){
        int i = s1.length()<s2.length() ? s1.length() : s2.length();
        int j =0;
        while( j !=i){
            if((s1.charAt(j) != s2.charAt(j)) && order.get(s1.charAt(j))<order.get(s2.charAt(j))){
                return true;
            }else if(s1.charAt(j) == s2.charAt(j)){
                j++;
            }else return false;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = null;
        s = scanner.next();
        int m=0;
        m = scanner.nextInt();
        String[] strArray = new String[m];
        for(int i=0; i<m; i++){
            strArray[i] = scanner.next();
        }
        System.out.print(isAlienSorted(strArray, s));
        scanner.close();
    }
}
