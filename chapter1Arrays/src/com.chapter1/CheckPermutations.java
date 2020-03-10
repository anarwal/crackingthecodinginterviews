package com.chapter1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/10/20.
 * Check Permutations: Given two strings, check if they are permutation of each other
 */

public class CheckPermutations {

    static boolean checkPermutations(String str1, String str2){
        HashMap<Character, Integer> hmap = new HashMap<>();
        if(str1.length() != str2.length()){
            return false;
        }
        for(int i=0; i<str1.length(); i++){
            hmap.put(str1.charAt(i), hmap.getOrDefault(str1.charAt(i), 0)+1);
        }
        for(int j=0; j<str2.length();j++){
            if(!hmap.containsKey(str2.charAt(j))){
                return false;
            }else if(hmap.get(str2.charAt(j)) == 1){
                hmap.remove(str2.charAt(j));
            }else{
                hmap.put(str1.charAt(j), hmap.get(str2.charAt(j)-1));
            }
        }
        if (!hmap.isEmpty()){
           return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        boolean result = checkPermutations(str1, str2);
        System.out.println(result);
        scanner.close();
    }
}
