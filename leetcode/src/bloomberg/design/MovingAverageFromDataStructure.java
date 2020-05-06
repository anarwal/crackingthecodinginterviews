package bloomberg.design;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStructure {
    static class MovingAverage {

        LinkedList<Integer> queue;
        int size;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            if(queue.size() == size){
                queue.pollFirst();
                queue.add(val);
            }else{
                queue.add(val);
            }

            int average = 0;
            for(int i=0; i<queue.size(); i++){
                int num = queue.pollFirst();
                average += num;
                queue.add(num);
            }
            return (double) average/queue.size();
        }
    }

    public static void main(String[] args){
        int size = 3;
        MovingAverage obj = new MovingAverage(size);
        System.out.print(obj.next(1));
        System.out.print(obj.next(10));
        System.out.print(obj.next(3));
        System.out.print(obj.next(5));
    }
}
