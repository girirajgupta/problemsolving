package com.test;

public class Frog {

	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}
	
	static int solution(int X, int Y, int D) {
		int diff = Y-X;
		if(diff == 0) {
			return 0;
		}
		int steps = diff/D;
		if(diff % D > 0) {
			steps += 1;
		}
		
		return steps;
	}

}
