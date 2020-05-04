package bloomberg.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class FirstUnique {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(hmap.containsKey(s.charAt(i))){
                hmap.put(s.charAt(i), hmap.get(s.charAt(i))+1);
            }else{
                hmap.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i<s.length(); i++){
            if((int)hmap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] main){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int result = firstUniqChar(str);
        System.out.print(result);
        scanner.close();
    }
}
