package com.main.crackingcodinginterview.chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BabyNames {
/*
 * 	Baby Names: Each year, the government releases a list of the 10000 most common baby names
	and their frequencies (the number of babies with that name). The only problem with this is that
	some names have multiple spellings. For example, "John" and "Jon" are essentially the same name
	but would be listed separately in the list. Given two lists, one of names/frequencies and the other
	of pairs of equivalent names, write an algorithm to print a new list of the true frequency of each
	name. Note that if John and Jon are synonyms, and Jon and Johnny are synonyms, then John and
	Johnny are synonyms. (It is both transitive and symmetric.) In the final list, any name can be used
	as the "real " name.
	EXAMPLE
	Input:
	Names: John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
	Synonyms: (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
	Output: John (27), Kris (36)
	Hints:#478, #493,#512,#53~#586,#605,#655, #675,#704
 */
	
	static Map<String, Integer> index = new HashMap<>();
	static List<Integer> freqs = new ArrayList<>();
	public static void main(String[] args) {
		Map<String, Integer> namesWithF = new HashMap<>();
		namesWithF.put("John", 15);
		namesWithF.put("Jon", 12);
		namesWithF.put("Chris", 13);
		namesWithF.put("Kris", 4);
		namesWithF.put("Christopher", 19);
		Map<String, String> synonyms = new HashMap<>();
		synonyms.put("John", "Jon");
		synonyms.put("Johnny", "John");
		synonyms.put("Chris", "Kris");
		synonyms.put("Kris", "Christopher");
		
		printNames(namesWithF, synonyms);
	}
	
	public static void printNames(Map<String, Integer> namesWithF, Map<String, String> synonyms) {
		
		populateSynonyms(synonyms);
		for(Map.Entry<String, Integer> entry : namesWithF.entrySet()) {
			int index = getIndex(entry.getKey());
			int count = freqs.get(index) + entry.getValue();
			freqs.set(index, count);
		}
		
		System.out.print(freqs);
	}

	private static void populateSynonyms(Map<String, String> synonyms) {
		int count =0;
		for(Entry<String, String> entry : synonyms.entrySet()) {
			if(index.get(entry.getKey()) == null && index.get(entry.getValue()) == null) {
				index.put(entry.getKey(), count);
				index.put(entry.getValue(), count);
				freqs.add(count, 0);
				count++;
			} else if(index.get(entry.getKey()) != null) {
				index.put(entry.getValue(), index.get(entry.getKey()));
			} else {
				index.put(entry.getKey(), index.get(entry.getValue()));
			}
		}
	}

	private static int getIndex(String key) {
		return index.get(key);		
	}

}
