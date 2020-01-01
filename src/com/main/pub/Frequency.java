package com.main.pub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {
	static Map<Integer, Integer> frequency = new HashMap<>();
	static Map<Integer, Integer> frequencyToCount = new HashMap<>();
	
	public static void main(String[] args) {
		List<List<Integer>> outer = new ArrayList<>();
		List<Integer> inner = Arrays.asList(1,2);
		outer.add(inner);
		inner = Arrays.asList(2,3);
		outer.add(inner);
		inner = Arrays.asList(3,1);
		outer.add(inner);
		inner = Arrays.asList(3,2);
		outer.add(inner);
		System.out.println(getOutput(outer));
	}

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	queries.stream().forEach(node -> System.out.println(node.toString()));
        return queries.get(0);

    }
    
    static List<Integer> getOutput(List<List<Integer>> queries) {
    	List<Integer> output = new ArrayList<>();
    	queries.stream().forEach(node -> {
    		//System.out.println(node.toString());
    		switch (node.get(0)) {
			case 1:
				insert(node.get(1));
				break;
			case 2:
				remove(node.get(1));
				break;
			default:
				checkFrequency(output, node.get(1));
				break;
			}
    	});
    	return output;
    }
    private static void checkFrequency(List<Integer> output, int integer) {
		/*Collection<Integer> values = frequency.values();
		if(values.contains(integer)) {
			output.add(1);
		} else {
			output.add(0);
		}*/
    	if( frequencyToCount.containsKey(integer)) {
    		output.add(1);
    	} else {
    		output.add(0);
    	}
	}

	private static void insert(int integer) {
    	int freq = 1;
    	if(frequency.containsKey(integer)) {
    		freq = frequency.get(integer) + 1;
    	}
    	frequency.put(integer, freq);
    	updateCount(freq);
    }
	
	private static void updateCount(int key) {
		if(frequencyToCount.containsKey(key)) {
			int count = frequencyToCount.get(key);
			count = count + 1;
			frequencyToCount.put(key, count);
		} else {
			frequencyToCount.put(key, 1);
		}
		updateOldCount(key);		
	}

	private static void updateOldCount(int key) {
		if(frequencyToCount.containsKey(key-1)) {
			int count2 = frequencyToCount.get(key-1);
			count2 = count2 -1;
			if(count2 == 0) {
				frequencyToCount.remove(key -1);
			} else {
				frequencyToCount.put(key-1, count2);
			}
		}
	}

	private static void remove(int integer) {
		if(frequency.containsKey(integer)) {
    		int freq = frequency.get(integer) -1;
    		if(freq == 0) {
    			frequency.remove(integer);
    		} else {
    		    frequency.put(integer, freq);
    		}
    	}
	}
}
