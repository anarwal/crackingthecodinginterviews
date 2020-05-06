package bloomberg.others;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNeg = false;
        if(x<0){
            isNeg = true;
            x = -x;
        }
        int prevRev =0;
        int rev = 0;
        while(x !=0){
            int cur = x%10;
            rev = rev*10 + cur;
            if((rev-cur)/10 !=prevRev){
                return 0;
            }
            prevRev = rev;
            x = x/10;
        }
        return isNeg ? -rev : rev;
    }
}
