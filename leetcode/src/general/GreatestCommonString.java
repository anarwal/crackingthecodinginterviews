package general;

public class GreatestCommonString {
    public String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str2 == null) return "";
        if((str1.length() == str2.length()) && !str1.equals(str2)) return "";
        if(str1.equals(str2)) return str1;
        // find gcd number based on length (as that is how long string gcd will be)
        int gcd = gcdNumber(str1.length(), str2.length());
        //create substring using previously calculated gcd
        String result = str2.substring(0, gcd);

        //iteratively
        for(int i=0; i<str1.length(); i +=gcd){
            if(!str1.substring(i).startsWith(result)){
                return "";
            }
        }
        return result;
    }

    int gcdNumber(int a, int b){
        // if b exactly divides the number a, means b is the gcd
        if(a%b == 0) return b;
        //perform recursive subtraction to find modulo
        return gcdNumber(b, a%b);
    }
}
