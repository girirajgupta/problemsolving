package com.main.crackingcodinginterview.chapter17;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
/*
 * 	Missing Number: An array A contains all the integers from 0 to n, except for one number which
	is missing. In this problem, we cannot access an entire integer in A with a single operation. The
	elements of A are represented in binary, and the only operation we can use to access them is "fetch
	the jth bit of A [ i] ," which takes constant time. Write code to find the missing integer. Can you do
	itinO(n) time?
	Hints: #610, #659, #683
 */
	static List<BitInteger> bits = new ArrayList<>();
	public static void main(String[] args) {
		//bits.add(new BitInteger(0,0,0));
		bits.add(new BitInteger(0,0,1));
		bits.add(new BitInteger(0,1,0));
		bits.add(new BitInteger(0,1,1));
		bits.add(new BitInteger(1,0,0));
		bits.add(new BitInteger(1,0,1));
		bits.add(new BitInteger(1,1,0));
		bits.add(new BitInteger(1,1,1));
		System.out.println(getMissingNumber(bits, 8));
	}
	private static BitInteger getMissingNumber(List<BitInteger> bits, int width) {
		int numberOnes = findNumber(bits, 0, width, -1);
		int numberTens = findNumber(bits, 1, width, numberOnes);
		int numberH = findNumber(bits, 2, width, numberTens);
		BitInteger missingNumber = new BitInteger(numberH, numberTens, numberOnes);
		return missingNumber;
	}
	private static int findNumber(List<BitInteger> bits, int column, int length, int lastBit) {
		int countO = 0, count1 =0;
		for(int i =0; i< length-1;i++) {
			int n=-1;
			switch (column) {
			case 0:
				n = bits.get(i).getOnes();
				break;
			case 1:
				if(bits.get(i).getOnes() == lastBit) {
					n = bits.get(i).getTens();
				}				
				break;
			case 2:
				if(bits.get(i).getTens() == lastBit) {
					n = bits.get(i).getHundreds();
				}
				break;
			}
			if(n == 0) {
				countO++;
			} else if(n == 1) {
				count1++;
			}
			
		}
		if(countO > count1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	static class BitInteger {
		int ones, tens, hundreds;
		public BitInteger(int h, int t, int o) {
			ones = o;
			tens = t;
			hundreds = h;
		}
		
		public int getOnes() {
			return ones;
		}
		
		public int getTens() {
			return tens;
		}
		
		public int getHundreds() {
			return hundreds;
		}
		
		public String toString() {
			return hundreds + "" + tens + "" + ones;
		}
	}
}
