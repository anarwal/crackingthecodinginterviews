package thirtyDaysToCode;

//Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
public class PerformStringShift {
    public String stringShift(String s, int[][] shift) {
        int finalamount =0; //number of characters to move

        for(int[] val:shift ){
            if(val[0] == 0){
                finalamount += val[1];
            }else {
                finalamount -= val[1];
            }
        }
        if(finalamount>0){ //left rotate
            finalamount= finalamount % s.length();
            s= s.substring(finalamount) + s.substring(0, finalamount);
        }else if(finalamount<0){ //right rotate
            finalamount = Math.abs(finalamount) % s.length();
            s = s.substring(s.length()-finalamount) + s.substring(0, s.length() -finalamount);
        }

        return s;
    }
}
