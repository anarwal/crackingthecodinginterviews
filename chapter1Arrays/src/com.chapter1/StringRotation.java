package com.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/19/20.
 * String Rotation: Given two strings s1 and s2, check if s2 is a rotation of s1 using only one call to isSubstring
 */
//waterbottle
//erbottlewat

public class StringRotation {
    static boolean isRotation(String s1, String s2){
        if(s1.length() == s2.length()){
            String newStr = s1+s1;
            return isSubstring(newStr, s2);
        }
        return false;
    }

    static boolean isSubstring(String s1, String s2){
        List<String> alist = new ArrayList<>();
        for(int i=0; i<s1.length(); i++){
            for(int j=i+1; j<s1.length();j++){
                alist.add(s1.substring(i,j));
            }
        }
        if(alist.contains(s2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        boolean result = isRotation(s1,s2);
        System.out.println(result);
        scanner.close();
    }

}
