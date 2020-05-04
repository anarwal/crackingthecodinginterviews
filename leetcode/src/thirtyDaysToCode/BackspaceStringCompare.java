package thirtyDaysToCode;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i =0; i<S.length(); i++){
            if(S.charAt(i) != '#'){
                sb1.append(S.charAt(i));
            }else{
                if(sb1.length() != 0) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            }
        }

        for(int j =0; j<T.length(); j++){
            if(T.charAt(j) != '#'){
                sb2.append(T.charAt(j));
            }else{
                if(sb2.length() !=0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            }
        }
        if(sb1.toString().equals(sb2.toString())) {
            return true;
        }
        else{
            return false;
        }

    }
}
