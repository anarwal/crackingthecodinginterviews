package bloomberg.treeAndGraphs;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
       Stack<Integer> counter = new Stack<>();
       Stack<String> result = new Stack<>();
       String res =  "";
       int index = 0;

       while(index<s.length()){
           if(Character.isDigit(s.charAt(index))){
                int count =0;
                while(Character.isDigit(s.charAt(index))){
                   count = 10 * count +(s.charAt(index)-'0');
                    index +=1;
                }
                counter.push(count);
           }
           else if(s.charAt(index) == '['){
                result.push(res);
                res ="";
               index +=1;
           }
           else if(s.charAt(index) == ']'){
               StringBuilder sb = new StringBuilder(result.pop());
               int count = counter.pop();
               for(int i=0; i<count; i++){
                   sb.append(res);
               }
               res = sb.toString();
               index +=1;
           }
           else{
               res +=s.charAt(index);
               index +=1;
           }
       }

       return res;
    }

}
