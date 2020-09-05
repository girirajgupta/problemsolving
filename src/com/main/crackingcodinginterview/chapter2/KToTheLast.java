package com.main.crackingcodinginterview.chapter2;

import com.main.crackingcodinginterview.model.Node;
import com.main.crackingcodinginterview.model.NodeHelper;

public class KToTheLast {
	static int total;
	static int data;
	public static void main(String[] args) {
		//#8, #25, #41, #67, # 126
		// TODO Auto-generated method stub
		// Find total length, find total - k + 1 node in O(N/2 + N - K)
		// Recursion to reach end and start counting O(N) time and space
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 5));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 8));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 1));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 10));
		// Length of the linked list is known
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 8, 5));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 8, 8));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 8, 1));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8}), 8, 10));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7}), 7, 4));
		System.out.println(getKFromLast(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7}), 7, 5));
		//get length
		System.out.println(getLength(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8})));
		System.out.println(getLength(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7})));
		//Multiple values and Array
		//Iteratively 
		
		
	}

	private static int getKFromLast(Node linkedList, int k) {
		total = 0;
		data = -1;
		getNext(linkedList, k);
		return data;
	}

	private static void getNext(Node current, int k) {
		if(current != null) {
			getNext(current.getNext(), k);
			total++;
			if(total == k) {
				data = current.getData();
			}
		}
		
	}
	
	private static int getKFromLast(Node linkedList, int total, int k) {
		int n = total - k + 1;
		if (n < 1) {
			return -1;
		}
		int cur = 1;
		Node previous = linkedList, runner = linkedList;
		while(runner != null && runner.getNext() != null) {
			if(cur == n ) {
				return runner.getData();
			} else if (cur == n+1) {
				return previous.getData();
			}
			previous = runner.getNext();
			runner = runner.getNext().getNext();
			cur = cur + 2;
		}
		
		
		return previous.getData();
	}
	
	private static int getLength(Node list) {
		int length = 0;
		Node previous = list, runner = list;
		while(runner != null && runner.getNext() != null) {
			length = length + 2;
			previous = runner.getNext();
			runner = runner.getNext().getNext();			
		}
		
		if(runner!= null && runner.getNext() == null) {
			length++;
		}
		
		return length;
	}

}
