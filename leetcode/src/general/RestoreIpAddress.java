package general;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

    public static List<String> restoreIpAddresses(String s){
        List<String> result = new ArrayList<>();
        int n = s.length();

        for(int i=1; i<n && i<4; i++){
            String first = s.substring(0,i);
            if(!isValidSegment(first))
                continue;
            for(int j=1; i+j<n && j<4;j++){
                String second=s.substring(i, i+j);
                if(!isValidSegment(second))
                    continue;
                for(int k=1; i+j+k<n && k<4;k++){
                    String third = s.substring(i+j, i+j+k);
                    String fourth = s.substring(i+j+k);
                    if(!isValidSegment(third) || !isValidSegment(fourth)) {
                        continue;
                    }else{
                        result.add(first+"."+second+"."+third+"."+fourth);
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValidSegment(String s){
        if(s.length()>3)
            return false;
        if(s.startsWith("0") && s.length() >1)
            return false;
        int val =  Integer.parseInt(s);
        return val >=0 && val <=255;
    }

    public static void main(String[] args){
        List<String> result = restoreIpAddresses("25525511135");
        for(String s: result){
            System.out.println(s);
        }

    }
}
