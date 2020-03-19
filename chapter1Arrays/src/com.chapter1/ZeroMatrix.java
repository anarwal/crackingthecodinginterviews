package com.chapter1;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/19/20.
 * Zero Matrix: Write an algorithm such that if an element in an M*N matrix is 0, its enitre row is and column are zero
 */

public class ZeroMatrix {

    static void setZeroMatrix(int[][] array){
        boolean rowHasZero = false;
        boolean columnHasZero =false;

        //checking first row
        for(int i =0; i<array[0].length; i++){
            if(array[0][i] == 0){
                rowHasZero = true;
                break;
            }
        }

        //checking first column
        for(int j =0; j<array.length; j++){
            if(array[j][0] == 0){
                columnHasZero = true;
                break;
            }
        }

        // checking through rest of matrix
        for(int i =1; i<array.length; i++){
            for(int j =1; j<array[0].length; j++){
                if(array[i][j] == 0){
                    array[i][0] = 0;
                    array[j][0] = 0;
                }
            }
        }

        // nullify rows
        for(int i=1; i < array[0].length; i++){
            if(array[0][i] == 0){
                nullify(array, i);
            }
        }

        // nullify columns
        for(int j=1; j < array.length; j++){
            if(array[j][0] == 0){
                nullify(array, j);
            }
        }

        // nullify first zero
        if(rowHasZero){
            nullify(array, 0);
        }

        // nullify first column
        if(columnHasZero){
            nullify(array, 0);
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
        setZeroMatrix(arr);
        scanner.close();
    }
}
