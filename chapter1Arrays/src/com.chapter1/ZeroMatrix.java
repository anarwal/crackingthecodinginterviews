package com.chapter1;

import java.util.Scanner;

/**
 * Created by abhimanyunarwal on 3/19/20.
 * Zero Matrix: Write an algorithm such that if an element in an M*N matrix is 0, its enitre row is and column are zero
 */

public class ZeroMatrix {
    public static void setZeroes(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;
        //checking first column
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i]==0) {
                rowHasZero=true;
                break;
            }

        }

        //checking first row
        for(int j=0; j<matrix.length;j++){
            if(matrix[j][0]==0) {
                columnHasZero=true;
                break;
            }

        }

        //checking rest of matrix
        for(int i=1; i<matrix.length;i++){
            for(int j=1; j<matrix.length; j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }

            }
        }

        //setting columns zero
        for(int i=1; i<matrix[0].length; i++){
            if(matrix[0][i]==0)
                nullifyColumn(matrix, i);
        }

        //setting rows zero
        for(int j=1; j<matrix.length;j++){
            if(matrix[j][0]==0)
                nullifyRow(matrix, j);
        }

        if(columnHasZero) {
            nullifyColumn(matrix, 0);
        }

        if(rowHasZero) {
            nullifyRow(matrix, 0);
        }
    }

    static void nullifyColumn(int[][] array, int n){
        for(int i=0; i<array.length; i++){
            array[i][n]=0;
        }
    }

    static void nullifyRow(int[][] array, int n){
        for(int i=0; i<array[n].length; i++){
            array[n][i]=0;
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
        setZeroes(arr);
        scanner.close();
    }
}
