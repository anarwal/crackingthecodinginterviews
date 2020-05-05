package bloombergTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Days {
    public static List<Integer> cellCompete(int[] states, int days)
    {
        int nextday = days-1;
        int prev = 0;
        while (nextday > 0){
            prev = states[0];
            states[0] = states[1]^0;
            for(int i =1; i<states.length-1; i++){
                states[i] = prev^states[i+1];
                prev = states[i];
            }
            states[states.length-1] = prev^0;
            days--;
        }
        List<Integer> aList = new ArrayList<>();

        for (int index = 0; index < states.length; index++)
        {
            aList.add(states[index]);
        }
        return aList;
    }

    public static void main(String[] args) {
        int m, n = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int arr[] = new int[m];
        for(int i = 0; i < m; i++) {
                arr[i] =scanner.nextInt();
        }
        cellCompete(arr, n);
        scanner.close();
    }
}
