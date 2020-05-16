package general;

import java.util.*;

public class MaximumTradedStock {
    public static String maxTraded(String[] array){
        HashMap<String, Integer> stocks = new HashMap<>();
        for(int i=0; i<array.length; i++){
            String[] currentStock = array[i].split(":");
            if(stocks.containsKey(currentStock[0])){
                stocks.put(currentStock[0],stocks.get(currentStock[0])+Integer.parseInt(currentStock[1]));
            }else{
                stocks.put(currentStock[0], Integer.parseInt(currentStock[1]));
            }
        }
        PriorityQueue<String> maxHeap = new PriorityQueue(
                (w1, w2) -> stocks.get(w2)-stocks.get(w1));

        for(String string: stocks.keySet()){
            maxHeap.offer(string);
        }

        return maxHeap.peek();
    }
    public static void main(String[] args){
        String[] strArray = new String[]{"Netflix:500", "Apple:400", "Google:1000", "Amazon:2000", "Apple:700"};
        System.out.print(maxTraded(strArray));
    }
}


