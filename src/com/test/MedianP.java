package com.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MedianP {

	public static void main(String[] args) {
		//int[] exp = {1, 2, 3, 4, 4};
		int[] exp = {2, 3, 4, 2, 3, 6, 8, 4, 5 };
		//int[] exp = {10, 20, 30, 40, 50};
		System.out.println(getCount(exp, 5));
	}
	
	static int getCount(int[] expenditure, int d) {
		PriorityQueue<Integer> minQ = new PriorityQueue<>((a,b)-> -1 * a.compareTo(b));
		PriorityQueue<Integer> maxQ = new PriorityQueue<>();
		int numberOfNotifications = 0;
		int counter = 2;
		double median = 0;
		minQ.add(expenditure[0]);
		if(minQ.peek() <= expenditure[1]) {
			maxQ.add(expenditure[1]);
		} else {
			minQ.remove();
			minQ.add(expenditure[1]);
			maxQ.add(expenditure[0]);
		}
		median = (double) (minQ.peek() + maxQ.peek())/2;
		while(counter < d ) {
			if(minQ.peek() >= expenditure[counter]) {
				minQ.add(expenditure[counter]);
			} else {
				maxQ.add(expenditure[counter]);
			}
			if(minQ.size() == maxQ.size() || (minQ.size() == maxQ.size()+1) || (minQ.size()+1 == maxQ.size())) {
				//do nothing
			} else if(minQ.size() > maxQ.size()) {
				int item = minQ.remove();
				maxQ.add(item);
			} else if(maxQ.size() > minQ.size()) {
				int item = maxQ.remove();
				minQ.add(item);
			}
			if(minQ.size() == maxQ.size()) {
				median = (double) (minQ.peek() + maxQ.peek())/2;
			} else if( minQ.size() > maxQ.size()) {
				median = minQ.peek();
			} else {
				median = maxQ.peek();
			}
			counter++;
		}
		
		int index = d;
		int indexToRemove = 0;
		do {
			if(expenditure[index] >= 2 * median) {
				numberOfNotifications++;
			}
			if(expenditure[indexToRemove] <= minQ.peek()) {
				minQ.remove(expenditure[indexToRemove]);
			}else {
				maxQ.remove(expenditure[indexToRemove]);
			}
			indexToRemove++;
			if(minQ.size() == maxQ.size() || (minQ.size() == maxQ.size()+1) || (minQ.size()+1 == maxQ.size())) {
				// do nothing
			} else if(minQ.size() > maxQ.size()) {
				int item = minQ.remove();
				maxQ.add(item);
			} else if(maxQ.size() > minQ.size()) {
				int item = maxQ.remove();
				minQ.add(item);
			}
			
			if(minQ.peek() >= expenditure[index]) {
				minQ.add(expenditure[index]);
			} else {
				maxQ.add(expenditure[index]);
			}
/*			if(minQ.size() > maxQ.size()-1) {
				int item = minQ.remove();
				maxQ.add(item);
			} else if(maxQ.size() > minQ.size()-1) {
				int item = maxQ.remove();
				minQ.add(item);
			}*/
			if(minQ.size() == maxQ.size() || (minQ.size() == maxQ.size()+1) || (minQ.size()+1 == maxQ.size())) {
				// do nothing
			} else if(minQ.size() > maxQ.size()) {
				int item = minQ.remove();
				maxQ.add(item);
			} else if(maxQ.size() > minQ.size()) {
				int item = maxQ.remove();
				minQ.add(item);
			}
			if(minQ.size() == maxQ.size()) {
				median = (double) (minQ.peek() + maxQ.peek())/2;
			} else if( minQ.size() > maxQ.size()) {
				median = minQ.peek();
			} else {
				median = maxQ.peek();
			}
			index++;
		} while (index < expenditure.length);
		
		return numberOfNotifications;
	}

}
