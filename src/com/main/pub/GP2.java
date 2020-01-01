package com.main.pub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GP2 {
	static Map<Long, Integer> maps = new HashMap<>();
	static Map<Long, List<Integer>> mapWithIndex = new HashMap<>();
	public static void main(String[] args) {
		//List<Long> input = Arrays.asList(1l, 5l, 5l, 25l, 125l);
		List<Long> input =  Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
		System.out.println(getCount(input, 3));

	}
	static int getCount(List<Long> arr, long r) {
		int count = 0;
		for(int i=0; i < arr.size(); i++) {
			long value = arr.get(i);
			if(maps.containsKey(value)) {
				maps.put(value, (maps.get(value) + 1));
			} else {
				maps.put(value, 1);
			}
		}
		for(int i=0; i <arr.size(); i++) {
			long value = arr.get(i);
			long secondValue = value * r;
			long thirdValue = value * r * r;
			if(maps.containsKey(secondValue)) {
				int indexOfSecondValue = arr.indexOf(secondValue);
				int lastIndexOfSecondValue = arr.lastIndexOf(secondValue);
				if(indexOfSecondValue > i) {
				int countOfValue = maps.get(secondValue);
					if(maps.containsKey(thirdValue)) {
						int indexOfThirdValue = arr.indexOf(thirdValue);
						if(indexOfThirdValue > lastIndexOfSecondValue) {
						int countOfThirdValue = maps.get(thirdValue);
							count = count + (countOfValue * countOfThirdValue);
						}
					}
				}
			}
		}
		return count;
	}
}
