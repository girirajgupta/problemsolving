package com.main.crackingcodinginterview.chapter1;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] A ={{1,2,3,4,5},{0,0,4,6,0},{2,2,2,2,2},{0,9,8,7,0}};
		rotateMatrix(A);
	}

	private static void rotateMatrix(int[][] a) {
		printMatrix(a);		
		int[][] b = Arrays.stream(a)
                .map(a1 ->  Arrays.copyOf(a1, a1.length))
                .toArray(int[][]::new);
		rotate(a,b);
		printMatrix(b);		
	}


	private static void rotate(int[][] a, int[][] b) {
		int[] temp = a[1];
		for(int i=0; i< a.length; i++) {
			for(int j=0;j<temp.length;j++){
				if(a[i][j] == 0) {
					fillZero(b, i, j);
					
					if(i >= a.length) {
						break;
					}
				}
			}			
		}		
	}

	private static void fillZero(int[][] a, int row, int col) {
		for(int i =0; i < a.length; i++) {
			if(a[i][col] !=0 ) {
				a[i][col] = -1;
			}
		}
		for(int j =0; j < a[1].length; j++) {
			if(a[row][j] != 0) {
				a[row][j] = -1;
			}			
		}
		a[row][col] = -1;
	}

	private static void printMatrix(int[][] a) {
		int[] temp = a[1];
		for(int i=0; i< a.length; i++) {
			for(int j=0;j<temp.length;j++){
			System.out.print(a[i][j]);
			}
			System.out.println();
		}
		
	}

}
