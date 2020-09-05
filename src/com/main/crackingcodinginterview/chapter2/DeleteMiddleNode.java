package com.main.crackingcodinginterview.chapter2;

import com.main.crackingcodinginterview.model.Node;
import com.main.crackingcodinginterview.model.NodeHelper;

public class DeleteMiddleNode {

	/*
	 *  Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
		the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
		that node.
		EXAMPLE
		Input: the node c from the linked list a - >b- >c - >d - >e- >f
		Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
	 */
	public static void main(String[] args) {
		Node nodes = NodeHelper.getLinkedList(new int[]{1,2,3,4,5,6,7,8});
		// TODO Auto-generated method stub
		/*	Picture the list 1- > 5 - >9 - > 12. Removing 9 would make it look like 1- > 5 - > 12. You only
			have access to the 9 node. Can you make it look like the correct answer?
		*/
		NodeHelper.printList(nodes);
		deleteNode(NodeHelper.getNthNode(nodes, 5));
		NodeHelper.printList(nodes);

	}

	private static void deleteNode(Node node) {
		Node temp = node;
		Node prev = node;
		while(temp.getNext() != null) {
			prev = temp;
			temp.setData(temp.getNext().getData());
			temp.setNext(temp.getNext());
			temp = temp.getNext();
		}
		prev.setNext(null);
	}

}
