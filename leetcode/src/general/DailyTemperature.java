package general;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for(int i=T.length-1; i>0; i--){
            //if current element is bigger then what we have on top of stack, then remove it
            if(!stack.isEmpty() && T[stack.peek()] <=T[i]) stack.pop();
            //if current element is
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
        }

        return result;

    }
}
