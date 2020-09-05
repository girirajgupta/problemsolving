package com.main.crackingcodinginterview.chapter17;

import java.util.HashSet;
import java.util.Set;

public class ReSpace {
/*
 * 17.13 Re-Space: Oh, no! You have accidentally removed all spaces, punctuation, and capitalization in a
lengthy document. A sentence Iike"I reset the computer. It still didn't boot!"
became"iresetthecomputeri tstilldidntboot': You'll deal with the punctuation and capitalization
later; right now you need to re-insert the spaces. Most of the words are in a dictionary but
a few are not. Given a dictionary (a list of strings) and the document (a string)' design an algorithm
to unconcatenate the document in a way that minimizes the number of unrecognized characters.
EXAMPLE:
Input jesslookedjustliketimherbrother
Output: jess looked just like tim her brother (7 unrecognized characters)
Hints: #496, #623, #656, #677, #739, #749
 */
	public static void main(String[] args) {
		Set<String> dic = new HashSet<>();
		dic.add("looked");
		dic.add("just");
		dic.add("like");
		dic.add("her");
		dic.add("brother");
		dic.add("this");
		dic.add("is");
		dic.add("my");
		dic.add("favorite");
		dic.add("food");
		//dic.add("we");
		//dic.add("a");
		//dic.add("some");
		dic.add("awesome");
		System.out.println(reSpace(dic, "shelookedjustliketimherbrother"));
		System.out.println(reSpace(dic, "thisismikesfavoritefood"));
		System.out.println(reSpace(dic, "thisisawesome"));
	}

	private static String reSpace(Set<String> dic, String str) {
		Result[] results = new Result[str.length()];
		Result result = split(dic, results,str, 0);
		return result == null ? "" : result.toString();
	}

	private static Result split(Set<String> dic, Result[] results, String str, int index) {
		if(index >= str.length()) {
			return new Result(0, "");
		}
		if(results[index] != null) {
			return results[index];
		}
		
		int bestInvalids = Integer.MAX_VALUE;
		int start = index;
		String parsedStr = "";
		String partial="";
		while(start < str.length()) {
			partial += str.charAt(start);
			int invalid = Integer.MAX_VALUE;
			if(dic.contains(partial)) {
				invalid = 0;
			} else {
				invalid = partial.length();
			}
			if (invalid < bestInvalids) { 
				Result result = split(dic, results, str, start + 1);
				if (invalid + result.invalids < bestInvalids) {
					bestInvalids = invalid + result.invalids;
					parsedStr = partial + " " + result.sentence;
					if (bestInvalids == 0) {
						break; 
					}
				}
			}
			start++;
		}
		Result r1 = new Result(bestInvalids, parsedStr);
		results[index] = r1;
		return r1;
	}

	public static class Result {
		int invalids;
		String sentence;
		
		public Result(int i, String s) {
			invalids = i;
			sentence = s;
		}
		
		public int getInvalids(){
			return invalids;
		}
		
		public String getSentence() {
			return sentence;
		}
		
		public String toString() {
			return invalids + ":" + sentence;
		}
	}

}
