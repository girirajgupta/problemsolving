package com.main.crackingcodinginterview.chapter17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sun.prism.impl.Disposer.Target;

public class WordTransformer {
/*
 * 	Word Transformer: Given two words of equal length that are in a dictionary, write a method to
	transform one word into another word by changing only one letter at a time. The new word you get
	in each step must be in the dictionary.
	EXAMPLE
	Input: DAMP, LIKE
	Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
	Hints: #506, #535, #556, #580, #598, #618, #738
 */
	public static void main(String[] args) {
		Set<String> dic = new HashSet<>();
		dic.add("DAMP");
		dic.add("LIKE");
		dic.add("LAMP");
		dic.add("LIMP");
		dic.add("LIME");
		dic.add("LAKE");
		dic.add("LAME");
		dic.add("");
		dic.add("my");
		dic.add("favorite");
		dic.add("food");
		dic.add("awesome");
		List<String> words = new ArrayList<>();
		//words.add("LIKE");
		//transform(dic, words, "DAMP", "LIKE", 0);
		transform(dic, words, "LIKE", "DAMP", 0);
		System.out.println(words);
		//System.out.println(transform(dic, ""));
		//System.out.println(transform(dic, ""));		
	}
	
	public static Result transform(Set<String> dic, List words, String source, String target, int start) {
		if(start >= source.length() || start < 0 ) {
			return new Result(false, source); 
		} 
		
		Result res = new Result(false, source);
		
		int index = start;
		
		while(index < source.length()) {
			String newWord = source.substring(0, index) + target.substring(index, index+1) + source.substring(index+1);
			if(dic.contains(newWord)) {
				words.add(newWord);
				if(newWord.equals(target)) {
					return new Result(true, newWord);
				}
				res = transform(dic, words, newWord, target, start+1);
				if(res.found) {
					return res;
				}
			} else {
				res = transform(dic, words, source, target, start+1);
				if(res.found) {
					return res;
				}
				res = transform(dic, words, res.word, target, index--);
				if(res.found) {
					return res;
				}
			/*	res = transform(dic, words, source, target, index--);
				if(res.found) {
					return res;
				}*/
			}
			index++;
		}
		
		return res;
	}
	
	public static class Result {
		boolean found;
		String word;
		public Result(boolean f, String w) {
			found = f;
			word = w;			
		}
		
	}

}
