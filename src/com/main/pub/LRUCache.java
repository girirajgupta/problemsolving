package com.main.pub;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class LRUCache {

	public static void main(String[] args) {
		LRUC cache = new LRUC(5);
		cache.display();
		cache.get(1);
		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.get(5);
		cache.display();
		cache.get(2);
		cache.display();
		cache.get(6);
		cache.display();

		LRUC cache2 = new LRUC(5);
		cache2.display();
		cache2.get(1,"1");
		cache2.get(2, "2");
		cache2.get(3, "3");
		cache2.get(4, "4");
		cache2.get(5,"5");
		cache2.display();
		cache2.get(2, "2");
		cache2.display();
		cache2.get(6,"6");
		cache2.display();
		cache2.get(6, "6");
		cache2.display();
		cache2.get(1, "1");
		cache2.display();
	}

	static class LRUC {
		private int capacity;
		private Deque queue;
		private Set keyValue;
		private Map actualMap;
		
		public LRUC(int capacity) {
			this.capacity = capacity;
			queue = new LinkedList<Integer>();
			keyValue = new HashSet<Integer>();
			actualMap = new HashMap<Integer, String>();
		}
		
		public void display() {
			System.out.println("Queue is::");
			queue.stream().forEach(entry -> System.out.println(entry));
			System.out.println("Map is::" + actualMap.toString());	
		}
		
		public String get(int key, String value) {
			if(actualMap.containsKey(key)) {
				removeFromQueue(key);
				addToQueue(key);
			} else {
				addToQueue(key);
				addToMap(key, value);
			}
			
			return (String) actualMap.get(key);
		}
		
		private void addToMap(int key, String value) {
			actualMap.put(key, value);
		}
		
		public int get(int key) {
			if(keyValue.contains(key)) {
				removeFromQueue(key);
				addToQueue(key);
			} else {
				addToQueue(key);
				addToSet(key);
			}
			return key;
		}
		
		private void removeFromQueue(int key) {
			queue.remove(key);
		}
		
		private void addToQueue(int key) {
			if(queueIsFull()) {
				int lastRemoved = removeLastUsed();
				removeFromSet(lastRemoved);
				
			} 
			queue.addFirst(key);
		}
		
		private boolean queueIsFull() {
			return queue.size() == capacity;
		}
		
		private int removeLastUsed() {
			return (int) queue.removeLast();
		}
		
		private void removeFromSet(int key) {
			keyValue.remove(key);
			actualMap.remove(key);
		}
		
		private void addToSet(int key) {
			keyValue.add(key);
		}
	}
}
