package com.test;

import java.util.Stack;

public class Brackets {

	public static void main(String[] args) {
		System.out.println(solution("{[("));

	}
	static public int solution(String S) {
		Stack<Character> brackets = new Stack<>();
		if(S.isEmpty()) {
			return 0;
		}
		
		for(int i = 0; i< S.length(); i++) {
			char ch = S.charAt(i);
			if(ch == '[' || ch == '{' || ch == '(') {
				brackets.push(ch);
			} else {
				if(brackets.size() == 0) {
					return 0;
				} else if(!valid(ch, brackets)){
					return 0;
				}
			}
		}
		
		return brackets.isEmpty() ? 1: 0;
	}
	private static boolean valid(char currentBracket, Stack<Character> brackets) {
		char topMostElement = brackets.pop();
		return (currentBracket == ')' && topMostElement == '(') || 
			   (currentBracket == '}' && topMostElement == '{') ||
			   (currentBracket == ']' && topMostElement == '[');
	}
}
