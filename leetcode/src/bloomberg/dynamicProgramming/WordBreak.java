package bloomberg.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean result = test(s, wordDict, 0);
        return result;
    }
    static boolean test(String str, List<String> wordDict, int start){
        if(str.length() ==start) return true;
        for(int end = start+1; end<=str.length(); end++){
            if(wordDict.contains(str.substring(start, end)) && test(str, wordDict, end)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakMemo(String s, List<String> wordDict) {
        int i = 0;
        boolean result = testMemo(s, wordDict, i, new Boolean[s.length()]);
        return result;
    }

    boolean testMemo(String str, List<String> wordDict, int start, Boolean[] memo){
        if(start == str.length()) return true;
        if(memo[start] !=null){
            return memo[start];
        }

        for(int i=start+1; i<=str.length();i++){
            if(wordDict.contains(str.substring(start, i)) && testMemo(str, wordDict, i, memo)){
                return memo[start]=true;
            }
        }
        return memo[start]=false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = null;
        s = scanner.next();
        int m=0;
        m = scanner.nextInt();
        List<String> dict = new ArrayList<>();
        for(int i=0; i<m; i++){
            dict.add(scanner.next());
        }
        System.out.print(wordBreak(s, dict));
        scanner.close();
    }
}
