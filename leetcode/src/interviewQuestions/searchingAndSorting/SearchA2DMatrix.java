package interviewQuestions.searchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0) return false;
            // int index = 0;
            // for (int i = 0; i < matrix.length; i++) {
            //     index = Arrays.binarySearch(matrix[i], target);
            //     if(index>=0 && index <matrix[i].length) return true;
            // }
            // return false;

            int r = 0;
            int c = matrix[0].length -1;

            while(r<matrix.length && c>=0){
                if(matrix[r][c] == target) return true;
                if(matrix[r][c]>target) c--;
                else r++;
            }
            return false;
    }

    public static void main(String[] args) {
        int m, n, t = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int arr[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] =scanner.nextInt();
            }
        }
        t = scanner.nextInt();
        System.out.print(searchMatrix(arr, t));
        scanner.close();
    }
}
