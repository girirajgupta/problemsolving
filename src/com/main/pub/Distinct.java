package com.main.pub;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int[] A) {
		if(A.length == 0) {
			return 0;
		}
		Set<Integer> distincts = new HashSet<>();
		for(int i=0;i < A.length; i++) {
			distincts.add(A[i]);
		}
		
		return distincts.size();
		
	}
}
