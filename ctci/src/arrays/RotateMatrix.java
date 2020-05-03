package arrays;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/19/20.
 * Rotate Matrix: Given an image represented by N8N matrix, write a method to rotate the image by 90 degrees
 */

public class RotateMatrix {

    static void rotateMatrix(int[][] arr){
        for(int layer =0; layer< arr.length/2; layer++){
            int first = layer;
            int last = arr.length -1 - layer;
            for(int i = first; i< last; i++){
                int temp = i-first;

                // save value of top
                int top = arr[first][i];

                //move left to top
                arr[first][i] = arr[last-temp][first];

                //move bottom to left
                arr[last-temp][i] = arr[last][last-temp];

                //move right to bottom
                arr[last][last-temp] = arr[i][last];

                //move top to right
                arr[i][last] =top;
            }
        }
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
        rotateMatrix(arr);
        scanner.close();
    }
}
