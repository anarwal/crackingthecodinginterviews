package ThirtyDaysToCode;

import java.util.Stack;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        if (s == null) return true;
        char[] charArray = s.toCharArray();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        for(int i =0;i<charArray.length; i++){
            if(charArray[i] == '('){
                stack1.push(i);
            }else if(charArray[i] == '*'){
                stack2.push(i);
            }else{
                if(!stack1.isEmpty()) stack1.pop();
                else if (!stack2.isEmpty()) stack2.pop();
                else return false;
            }
        }

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek()<stack2.pop()) stack1.pop();
        }

        return stack1.isEmpty();
    }
}
