package com.main.crackingcodinginterview.model;

public class NodeHelper {

	public static Node getLinkedList(int[] data) {
		Node root = new Node(data[0]);
		for(int i=1; i< data.length; i++) {
			root.appendToTail(data[i]);
		}
		
		return root;
	}

	public static void printList(Node nodes) {
		Node temp = nodes;
		while( temp != null) {
			System.out.println( temp.data);
			 temp =  temp.getNext(); 
		}		
	}

	public static Node getNthNode(Node nodes, int n) {
		Node temp = nodes;
		int cur = 1;
		while(cur++ != n && temp != null) {
			temp = temp.getNext();
		}
		return temp;
	}

}
