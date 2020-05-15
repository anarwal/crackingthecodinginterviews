package general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromicSubstring {
    public static int countSubstrings(String s) {
        int counter =0;
        for(int i=0; i<=s.length(); i++){
            for(int j=i+1; j<=s.length();j++){
                if(isPalindrome(s.substring(i,j))){
                    counter++;
                }
            }
        }
        return counter;
    }

    static boolean isPalindrome(String s){
        if(s.length() == 1) return true;
        else{
            int i=0;
            int j=s.length()-1;
            while(i<j){
                if(s.charAt(i) !=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String m = scanner.next();
        int result = countSubstrings(m);
        System.out.print(result);
        scanner.close();
    }
}
