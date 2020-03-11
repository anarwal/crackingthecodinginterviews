package com.chapter1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/11/20.
 * Palindrome Permutations: Given a string, check if it is a permutation of palindrome
 */

public class PalindromePermutations {

    static boolean isPalindromePermutation(String s){
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i =0; i<s.length();i++){
            if(s.charAt(i)== ' '){}
            else{
                hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
            }
        }
        int counter =0;
        for(HashMap.Entry me : hmap.entrySet()){
            if((int)me.getValue()%2 != 0){
                counter++;
            }
        }
        if(counter != 1){
            return false;
        }
        return true;
    }

    static boolean isPalindromePermutationAnotherSolution(String s){
        int countodd =0;

        int[] arr= new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];
        for(char c : s.toCharArray()){
            int x = getCharNumber(c);
            if( x != -1){
                arr[x]++;
                if (arr[x] %2 == 1) {
                    countodd++;
                } else {
                    countodd--;
                }
            }
        }
        return countodd <=1;
    }

    static int getCharNumber(Character c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(c);
        if(a <=val && val <=z){
            return val-a;
        }else if( A <=val && val <=Z){
            return val-A;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("First Solution: "+isPalindromePermutation(str));
        System.out.println("Second Solution: "+isPalindromePermutationAnotherSolution(str));
        scanner.close();
    }
}
