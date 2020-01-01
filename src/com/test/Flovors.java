package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Flovors {

	public static void main(String[] args) {
		//int[] costs = {1, 4, 5, 3, 2};
		int[] costs = {2, 2, 4, 3};
		printFlavors(costs, 4);

	}
	
	static void printFlavors(int[] cost, int money) {
		Set<Integer> prices = new HashSet<>();
		for(int i=0; i< cost.length; i++) {
			prices.add(cost[i]);
		}
		//Arrays.sort(cost);
		for(int i=0; i< cost.length; i++) {
			int priceone = cost[i];
			int remainingMoney = money - priceone;
			if(prices.contains(remainingMoney)) {
				int index = findFlovour(cost, i+1, remainingMoney);
				if (index > i) {
					System.out.println(i+1 + " " + (index+1));
				}
			}
		}
    }

	private static int findFlovour(int[] cost, int i, int remainingMoney) {
		for(int j = i; j < cost.length; j++) {
			if(cost[j] == remainingMoney) {
				return j;
			}
		}
		return -1;
	}

}
