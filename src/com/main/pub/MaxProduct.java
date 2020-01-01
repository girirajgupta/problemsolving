package com.main.pub;

import java.util.PriorityQueue;

public class MaxProduct {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		System.out.println(solution(A));

	}
	public static int solution(int[] A) {
		PriorityQueue<Integer> maxQ = new PriorityQueue<>((a,b) -> -1*a.compareTo(b));
		PriorityQueue<Integer> maxQ2 = new PriorityQueue<>((a,b) -> -1*a.compareTo(b));
		for (Integer integer : A) {
			if(integer >= 0) {
				maxQ.add(integer);
			} else {
				maxQ2.add(integer);
			}
		}

		
		if(maxQ.size() == 0) {
			return maxQ2.poll() * maxQ2.poll() * maxQ2.poll();
		}
		
		if(maxQ2.size() == 0 || maxQ2.size() == 1) {
			return maxQ.poll() * maxQ.poll() * maxQ.poll();
		}
		
		
		if(maxQ.size() == 1) {
			return maxQ.poll() * maxQ2.poll() * maxQ2.poll();
		}

		int p1 = maxQ.poll();
		int p2 = maxQ.poll();
		int p3 = maxQ.poll();
		
		int n1 = maxQ2.poll();
		int n2 = maxQ2.poll();
		
		int sum1 = p1 * n1 * n2;
		int sum2 = p1 * p2 * p3;
		
		return Math.max(sum1, sum2);
		
	}
}
