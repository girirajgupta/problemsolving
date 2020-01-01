package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GP {
	
	static Map<Long, List<Integer>> maps = new HashMap<>();
	
	public static void main(String args[]) {
		List<Long> input = Arrays.asList(1l, 5l, 5l, 25l, 125l);
		//List<Long> input =  Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
		System.out.println(getCount(input, 5));
	}
	
	static int getCount(List<Long> arr, long r) {
		int count = 0;
		long[] gps = {r, r*r};
		
		for(int i=0; i<arr.size();i++) {
			long firstNumber = arr.get(i);
			long secondNumber = firstNumber * gps[0];
			long thirdNumber = firstNumber * gps[1];
			//System.out.println(" first number is ::" + firstNumber);
			List<Integer> indices = getIndices(arr, secondNumber, i+1);
			//System.out.println(" second numbers is ::" + indices.toString());
			if(indices.size() != 0) {
				for(int j=0; j< indices.size(); j++) {
					List<Integer> indicesTwo = getIndices(arr, thirdNumber, indices.get(j) + 1);
				//	System.out.println(" third number is ::" + indicesTwo.toString());
					count = count + indicesTwo.size();
				}
			}
		}
		return count;
	}

	private static List<Integer> getIndices(List<Long> arr, long value, int startingIndex) {
		
		if(maps.containsKey(value)) {
			List<Integer> tmpInd = maps.get(value);
			List<Integer> result = tmpInd.stream()                // convert list to stream
	                .filter(index -> index >= startingIndex)     // we dont like mkyong
	                .collect(Collectors.toList()); 
			return result;
		} else {
			List<Integer> indices = new ArrayList<>();	
		for(int i = startingIndex; i < arr.size(); i++) {
			if(i > arr.size()) {
				break;
			}
			if(arr.get(i) == value) {
				indices.add(i);
			}
		}
		//maps.put(value, Lists.newArrayList(indices));
		return indices;
		}
		
	}
}
