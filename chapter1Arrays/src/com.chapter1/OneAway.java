package com.chapter1;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/18/20.
 * One Away: Given two strings, check if they are one edit(insert, remove, replace) away
 */

public class OneAway {
    static boolean oneAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return oneEditReplace(s1, s2);
        }else if(s1.length() -1 == s2.length()){
            return oneEditInsert(s1, s2);
        }else if(s1.length() +1 == s2.length()){
            return oneEditInsert(s1, s2);
        }
        return false;
    }

    static boolean oneEditReplace(String s1,String s2){
        boolean founddiff = false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(founddiff){
                    return false;
                }else{
                    founddiff = true;
                }
            }
        }
        return true;
    }

    static boolean oneEditInsert(String s1,String s2){
        int index1=0;
        int index2=0;
        while(index1<s1.length() && index2<s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;

            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        boolean result = oneAway(s1, s2);
        System.out.println(result);
        scanner.close();
    }
}

