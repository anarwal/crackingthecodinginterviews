package thirtyDaysToCode;

import java.util.List;

// Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
public class LeftmostWithAtleastOne {
    interface BinaryMatrix {
        int x = 0;
        int y = 0;
        public int get(int x, int y);
        public List<Integer> dimensions();
    }
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int n = binaryMatrix.dimensions().get(0);
        int m = binaryMatrix.dimensions().get(1);
        int minRow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = m - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (binaryMatrix.get(i, mid) < 1) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (binaryMatrix.get(i, start) == 1) {
                minRow = Math.min(minRow, start);
            }
        }
        return minRow != Integer.MAX_VALUE ? minRow : -1;
    }
}
