package ThirtyDaysToCode;

import java.util.Stack;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/
public class MinimumStack {

    Stack<Integer> stack;
    int min;

    public MinimumStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int data){
        if(data <=min){
            stack.push(min);
            min = data;
        }
        stack.push(data);
    }

    public void pop() {
        if(min == stack.pop()){
            min =stack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min;
    }
}
