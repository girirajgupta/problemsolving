package com.test;

import java.util.ArrayList;
import java.util.List;

public class SolutionB {

	public static void main(String[] args) {
		/*System.out.println(solution(4,4));
		System.out.println(solution(1,1));
		System.out.println(solution(0,0));*/
		System.out.println(solution(21,20));
		System.out.println(solution(21,15));
		System.out.println(solution(19,21));
		System.out.println(solution(4,1));
		System.out.println(solution(5,2));
		System.out.println(solution(5,3));
		System.out.println(solution(5,4));
	}
	
	public static String solution(int A, int B) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
		if(A == B) {
			for(int i = 0 ;i < A; i++) {
				first.add("a");
				second.add("b");
			}
        }
		String firstLetter;
		String secondLetter;
		int firstSize =0;
		int secondSize =0;
		if(A > B) {
			firstLetter = "a";
			secondLetter = "b";
			firstSize = A;
			secondSize = B;
		} else {
			firstLetter = "b";
			secondLetter = "a";
			firstSize = B;
			secondSize = A;
		}
		
		for(int i= 0 ; i< firstSize/2; i++) {
			first.add(firstLetter + firstLetter);
		}
		
		if(firstSize%2 == 1) {
			first.add(firstLetter);
		}
		
		int k = 0;
		int doubleEntries = secondSize - first.size();
		int j=0;
		int totalB=0;
		while(k < first.size()) {
			if(j< doubleEntries) {
				second.add(secondLetter + secondLetter);
				totalB += 2;
			} else {
				if(totalB < secondSize) {
					second.add(secondLetter);
				}
				totalB +=1;
			}
			j++;
			k++;
		}
		StringBuilder builder = new StringBuilder();
		for(int i=0; i < first.size(); i++) {
			builder.append(first.get(i));
			if(i < second.size() ) {
				builder.append(second.get(i));
			}
		}
		
		return builder.toString();
    }

}
