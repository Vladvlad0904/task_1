package com.company;

import java.util.Scanner;

public class Main {

    /**
     * Дана целочисленная прямоугольная матрица.
     * Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n=in.nextInt(), m=in.nextInt();

        int[][] A = new int[n][m]; // наша матрица

        for(int i=0; i<n; ++i)
            for(int j=0; j<m; ++j)
                A[i][j] = in.nextInt();

        int[] same = new int[n]; // длина самой длинной серии одинаковых элементов в строке

        int t;

        for(int i=0; i<n; ++i) {

            same[i]=1;

            t=1;
            for (int j = 1; j < m; ++j) {

                if(A[i][j]==A[i][j-1]) ++t;
                else{
                    if(same[i]<t) same[i]=t;

                    t=1;
                }

            }

            if(same[i]<t) same[i]=t;

        }


        int z;


        // сортируем пузырьком
        for(int i1=0; i1<n-1; ++i1)
            for(int i=0; i<n-1; ++i)
                if(same[i]>same[i+1]) {

                    for (int j = 0; j < m; ++j) {
                        z = A[i][j];
                        A[i][j] = A[i+1][j];
                        A[i+1][j] = z;
                    }

                    z=same[i];
                    same[i]=same[i+1];
                    same[i+1]=z;
                }





        for(int i=0; i<n; ++i)
        {
            for(int j=0; j<m; ++j) System.out.print(A[i][j]+" ");

            System.out.print("\n");
        }



    }
}