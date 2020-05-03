package BloombergTop;

import java.util.*;

public class TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs((o2[0] - o2[1])) -  Math.abs(o1[0] - o1[1]);
            }
        });

        int res = 0;
        int n = costs.length/2;
        //counters for number of people for each city
        int c1 = 0, c2 = 0;
        for (int i = 0; i < 2*n; i++){
            if (costs[i][0] <= costs[i][1]){
                if (c1 < n){
                    res += costs[i][0];
                    c1++;
                }
                else if (c2 < n) {
                    res += costs[i][1];
                    c2++;
                }
            }
            else {
                if (c2 < n){
                    res += costs[i][1];
                    c2++;
                }
                else if (c1 < n) {
                    res += costs[i][0];
                    c1++;
                }
            }
        }
        return res;

//        Arrays.sort(costs,(int[] a, int[] b) -> (a[0] - a[1]) - (b[0] - b[1]));
//        int totalCost = 0;
//        for(int i = 0; i<costs.length/2; i++)
//            totalCost += costs[i][0];
//        for(int i = costs.length/2 ; i < costs.length ; i++)
//            totalCost += costs[i][1];
//        return totalCost;
    }

    public static void main(String[] args) {
        int m, n = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] =scanner.nextInt();
            }
        }
        twoCitySchedCost(arr);
        scanner.close();
    }
}
