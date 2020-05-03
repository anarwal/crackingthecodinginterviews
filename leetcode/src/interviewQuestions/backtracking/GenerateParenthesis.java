package interviewQuestions.backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/794/

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> aList = new ArrayList<>();
        backtrack(n,aList, "", 0, 0);
        return aList;
    }

    void backtrack(int n, List<String> list, String currentString, int open, int close){
        if(currentString.length() == n*2){
            list.add(currentString);
            return;
        }
        if(open<n){
            backtrack(n, list, currentString+"(", open+1, close);
        }
        if(close<open){
            backtrack(n, list, currentString+")", open, close+1);
        }
    }
}
