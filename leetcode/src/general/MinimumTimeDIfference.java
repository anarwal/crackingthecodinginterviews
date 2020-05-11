package general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumTimeDIfference {
    public static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<timePoints.size(); i++){
            for(int j=i+1; j<timePoints.size(); j++){
                String[] A =  timePoints.get(i).split(":");
                String[] B =  timePoints.get(j).split(":");
                int AMin  = Integer.parseInt(A[1].trim());
                int BMin  = Integer.parseInt(B[1].trim());
                int minDiff = AMin - BMin;
                if(minDiff<0){
                    minDiff = 60+minDiff;
                }
                min = Math.min(min, minDiff);
            }
        }
        return min;
    }


    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        List<String> alist = new ArrayList<>();
        for(int i=0; i<m;i++){
            alist.add(scanner.next());
        }
        int result = findMinDifference(alist);
        System.out.print(result);
        scanner.close();
    }


}
