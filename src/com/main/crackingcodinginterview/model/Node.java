package com.main.crackingcodinginterview.model;

public class Node {
	Node next = null;
	int data;
	public Node( int d) {
		data = d;
	}
	
	public void setData(int d) {
		data = d;
	}

	public void setNext(Node node) {
		next = node;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public Node getNext() {
		return next;
	}
	
	public int getData() {
		return data;
	}
}