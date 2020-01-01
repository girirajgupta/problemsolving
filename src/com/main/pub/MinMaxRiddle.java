package com.main.pub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinMaxRiddle {

	public static void main(String[] args) {
		long[] input = {3, 5, 4, 7, 6, 2};
		//long[] input = {1, 2, 3, 5, 1, 13, 3};

		Arrays.stream(getriddle(input)).forEach(n -> System.out.println(n));

	}
	
	static long[] getriddle(long[] arr) {
        long[] results = new long[arr.length];

        PriorityQueue<Long> maxQ = new PriorityQueue<>((a,b) -> -1*a.compareTo(b));
        for(int i=1; i <= arr.length; i++) {
        	int window = i;
        	List<Long> minsOfWindows = getWindows(arr, window);
        	minsOfWindows.stream().forEach(e -> maxQ.add(e));
        	results[i-1] = maxQ.peek();
        	maxQ.clear();
        }
      
        return results;
 
    }

	private static List<Long> getWindows(long[] arr, int window) {
		List<Long> mins = new ArrayList<>();
        PriorityQueue<Long> minQ = new PriorityQueue<>();
		for(int i=0; i< arr.length-window+1; i++) {
			int mem =0;
			while(mem < window && (mem+i) < arr.length) {
				minQ.add(arr[i+mem]);
				mem++;
			}
			if(!minQ.isEmpty()) {
				mins.add(minQ.peek());
				minQ.clear();
			}
			/*if(i+window > arr.length) {
				break;
			}*/
		}
		
		return mins;
	}

}
