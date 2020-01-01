package com.test;

import java.util.Stack;

public class StoneWall {

	public static void main(String[] args) {
		int[] H = {8,8,5,7,9,8,7,4,8};
		System.out.println(solution(H));

	}
	static public int solution(int[] H) {
		Stack<Integer> walls = new Stack<>();
		int count =0;
		for(int i=0; i< H.length; i++) {
			if(walls.isEmpty()) {
				walls.add(H[i]);
				count++;
			} else {
				int curSize = walls.peek();
				if(curSize == H[i]) {
					//do nothing 
				} else if(H[i] > curSize) {
					walls.add(H[i]);
					count++;
				} else {
					walls.pop();
					while(!walls.isEmpty() && H[i] < walls.peek() ) {
						walls.pop();
					}
					if(walls.isEmpty()) {
						walls.add(H[i]);
						count++;
					} else if(walls.peek() == H[i]) {
						//do nothing
					} else {
						walls.add(H[i]);
						count++;
					}
				}
				
			}
		}
		
		return count;
	}
}
