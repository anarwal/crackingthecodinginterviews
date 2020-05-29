package general;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        // checking in constant time
        HashSet<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));

        // keep a track of all visited nodes
        HashSet<String> visited = new HashSet<>();

        //add first value
        visited.add("0000");
        //initialie queue for running BFS
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0; j<size; j++){
                //take out the string we are on
                String str = queue.poll();
                // do not check if this string is deadend
                if(deadEndSet.contains(str)) {
                    continue;
                }

                //if string equals target return steps
                if(str.equals(target)) return steps;
                StringBuilder sb = new StringBuilder(str);
                // create next options
                for(int i=0; i<4; i++){
                    String s1 = sb.substring(0,i) + (sb.charAt(i) == '9' ? 0 : sb.charAt(i)-'0' +1) + sb.substring(i+1);
                    String s2 = sb.substring(0,i)+ (sb.charAt(i) == '0' ? 9 : sb.charAt(i)-'0' -1) + sb.substring(i+1);

                    if(!deadEndSet.contains(s1) && !visited.contains(s1)){
                        queue.add(s1);
                        visited.add(s1);
                    }
                    if(!deadEndSet.contains(s2) && !visited.contains(s2)){
                        queue.add(s2);
                        visited.add(s2);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
