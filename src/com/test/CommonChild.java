package com.test;

public class CommonChild {

	public static void main(String[] args) {
		System.out.println(getChild("SHINCHAN", "NOHARAAA"));
		System.out.println(getChild("AA", "BB"));
		System.out.println(getChild("HARRY", "SALLY"));
		System.out.println(getChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC"));
	}
	
	static int getChild(String s1, String s2) {
		int row = s1.length() + 1;
		int column = s2.length() + 1;
		
		int[][] table = new int[row][column];
		
		for(int i =1; i < row; i++) {
			for (int j=1; j< column; j++) {
				//System.out.println("from s1" + s1.charAt(i-1));
				//System.out.println("from s2" + s2.charAt(j-1));
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					table[i][j] = table[i-1][j-1] + 1;
				} else {
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
			}
		}
		
		return table[row-1][column-1];
		
	}
	
}
