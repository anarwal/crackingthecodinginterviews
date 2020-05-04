package bloomberg.heapQueueAndStacks;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<charArray.length; i++){
            if(charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '['){
                stack.push(charArray[i]);
            }else if(!stack.isEmpty() && charArray[i] == ')' && stack.peek()== '('){
                stack.pop();
            }else if(!stack.isEmpty() && charArray[i] == '}' && stack.peek()== '{'){
                stack.pop();
            }else if(!stack.isEmpty() && charArray[i] == ']' && stack.peek()== '['){
                stack.pop();
            }else{
                return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
