package com.main.crackingcodinginterview.chapter2;

import com.main.crackingcodinginterview.model.Node;
import com.main.crackingcodinginterview.model.NodeHelper;

public class Partition {
/*
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
	before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
	to be after the elements less than x (see below). The partition element x can appear anywhere in the
	"right partition"; it does not need to appear between the left and right partitions.
	EXAMPLE
	Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5)
	Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
	Hints: #3, #24
 */
	public static void main(String[] args) {
		partition(NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8,9}),5);
		partition(NodeHelper.getLinkedList(new int[]{9,8,7,6,5,4,3,2,1}),5);
		partition(NodeHelper.getLinkedList(new int[]{1,9,2,8,3,7,4,6,5}),5);
	}
	
	private static void partition(Node nodes, int i) {
		NodeHelper.printList(nodes);
		nodes = doPartition(nodes, i);
		//NodeHelper.printList(nodes);
	}

	private static Node doPartition(Node nodes, int i) {
		Node lNode = null;
		Node rNode = null;
		Node ptemp = null;
		Node temp = nodes;
		while(temp != null) {
			if(temp.getData() < i) {
				if(lNode == null) {
					lNode = new Node(temp.getData());
				} else {
					lNode.appendToTail(temp.getData());
				}
				
			} else {
				if(rNode == null) {
					rNode = new Node(temp.getData());
				} else {
					rNode.appendToTail(temp.getData());
				}
			}
			ptemp = temp;
			temp = temp.getNext();
		}
		ptemp.setNext(null);
		System.out.println("hello");
		NodeHelper.printList(lNode);
		System.out.println("hello right");
		NodeHelper.printList(rNode);
		return lNode;
	}

}
