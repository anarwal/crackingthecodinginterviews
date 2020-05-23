package general;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPAddressQuestion {
    // Complete the checkIPs function below.

    static List<String> checkIPs(List<String> ip_array) {
        List<String> result = new ArrayList<>();
        for(String s: ip_array){
            String[] strArray = s.split("\\.");
            try{
                if(strArray.length == 4){
                    if(!(validString(strArray[0]))&& !(validString(strArray[1]))
                            && !(validString(strArray[2])) && !(validString(strArray[3]))){
                        continue;
                    }else result.add("IPv4");
                }else{
                    result.add("Invalid");
                }
            }catch(Exception e){
                result.add("Invalid");
            }
        }
        return result;

    }



    public static boolean validString(String s){
        if(s.length()>3) return false;
        if(s.startsWith("0") && s.length() >1) return false;
        int valueOfString = Integer.parseInt(s);
        return valueOfString >=0 && valueOfString <=255;
    }



    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int m =0;
        m =sc.nextInt();
        List<String> alist = new ArrayList<>();
        for(int i=0; i<m;i++){
            alist.add(sc.next());
        }
        List<String> result = checkIPs(alist);
        for(String s: result){
            System.out.println(s);
        }

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int ip_arrayCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> ip_array = new ArrayList<>();
//
//        IntStream.range(0, ip_arrayCount).forEach(i -> {
//
//            try {
//
//                ip_array.add(bufferedReader.readLine());
//
//            } catch (IOException ex) {
//
//                throw new RuntimeException(ex);
//
//            }
//
//        });
//        List<String> res = checkIPs(ip_array);
//
//        bufferedWriter.write(
//
//                res.stream()
//
//                        .collect(joining("\n"))
//
//                        + "\n"
//
//        );
//
//
//
//        bufferedReader.close();
//
//        bufferedWriter.close();

    }

}

