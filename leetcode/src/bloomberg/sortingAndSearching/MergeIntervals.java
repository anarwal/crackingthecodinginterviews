package bloomberg.sortingAndSearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1 ) return intervals;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        LinkedList<int[]> result = new LinkedList<>();

        result.add(intervals[0]);
        for (int j = 1; j < intervals.length; j++) {
            if (result.getLast()[1] < intervals[j][0]){
                result.addLast(intervals[j]);
            }
            else {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[j][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
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
        merge(arr);
        scanner.close();
    }
}
