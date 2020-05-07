package bloomberg.sortingAndSearching;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortCharactersByFrequency {
    public static String frequencySort(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(hmap.containsKey(s.charAt(i))){
                hmap.put(s.charAt(i), hmap.get(s.charAt(i))+1);
            }else{
                hmap.put(s.charAt(i), 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Character> pq = new PriorityQueue<>((v1, v2)-> hmap.get(v2)- hmap.get(v1));
        for(Map.Entry me : hmap.entrySet()){
            pq.offer((char)me.getKey());
        }

        while(!pq.isEmpty()){
            char c = pq.remove();
            for(int i=0; i<hmap.get(c); i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String result = frequencySort(str);
        System.out.println(result);
        scanner.close();
    }
}
