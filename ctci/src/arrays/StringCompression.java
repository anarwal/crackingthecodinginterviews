package arrays;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/18/20.
 * String Compression: Implement a method to perform basic string compression
 */

public class StringCompression {
    static String stringCompress(String s){
        StringBuilder str = new StringBuilder();
        int counter = 0;
        for(int i=0; i<s.length();i++){
            counter++;
            // until we reach end of the array or next character is different
            if(i+1>=s.length() || s.charAt(i) !=s.charAt(i+1)){
                str.append(s.charAt(i));
                str.append(counter);
                counter=0;
            }
        }
        System.out.println(str);
        if(str.length() >= s.length()) {
            return s;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result = stringCompress(str);
        System.out.println(result);
        scanner.close();
    }
}
