package arrays;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/10/20.
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. You can not use any extra data structure.
 */

public class IsUnique {

    static boolean isUnique(String str){
        if (str.length() >128){
            return false;
        }
        boolean[] charArray = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if (charArray[val]){
                return false;
            }
            charArray[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean result = isUnique(str);
        System.out.println(result);
        scanner.close();
    }
}
