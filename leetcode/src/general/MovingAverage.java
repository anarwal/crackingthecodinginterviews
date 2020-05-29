package general;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    Queue<Integer> q;
    int k;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.k = size;
        q= new LinkedList<Integer>(Collections.singleton(size));
    }

    public double next(int val) {
        int sum = 0 ;
        if(q.size() ==k){
            q.poll();
        }
        q.offer(val);
        for(Integer i: q){
            int newNum = q.poll();
            sum +=newNum;
            q.offer(newNum);
        }
        return (double) sum/k;
    }
}
