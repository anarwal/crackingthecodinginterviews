package com.chapter1;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/10/20.
 * URLify: Given a string, replace all spaces with "%20"
 */

public class URLify {
    static String urlify(String s){
        int spaces =0;
        int len = s.length();
        char[] charArr = s.toCharArray();
        for(int i =0; i<len;i++){
            if(charArr[i] == ' '){
                spaces++;
            }
        }
        int newArrLength = charArr.length + spaces*2;
        char[] newCharArray = new char[newArrLength];
        for(int j = len-1; j >=0;j--){
            if(charArr[j] == ' '){
                newCharArray[newArrLength-1]='%';
                newCharArray[newArrLength-2]='2';
                newCharArray[newArrLength-3]='0';
                newArrLength = newArrLength-3;
            }else{
                newCharArray[newArrLength-1]=charArr[j];
                newArrLength =newArrLength-1;
            }
        }
        return new String(newCharArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result = urlify(str);
        System.out.println(result);
        scanner.close();
    }
}
