package com.main.crackingcodinginterview.chapter4;

import com.main.crackingcodinginterview.model.BinaryTree;
import com.main.crackingcodinginterview.model.BinaryTree.Node;

public class CheckBalanced {
/*
 * 	Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
	this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
	node never differ by more than one.
	Hints: #2 7, #33, #49, # 705, #724
 */
	public static void main(String[] args) {
		BinaryTree.Node root = new BinaryTree.Node(1);
		BinaryTree.Node node1 = new BinaryTree.Node(1);
		BinaryTree.Node node2 = new BinaryTree.Node(1);
		BinaryTree.Node node3 = new BinaryTree.Node(1);
		BinaryTree.Node node4 = new BinaryTree.Node(1);
		BinaryTree.Node node5 = new BinaryTree.Node(1);
		BinaryTree.Node node6 = new BinaryTree.Node(1);
		BinaryTree.Node node7 = new BinaryTree.Node(1);
		BinaryTree.Node node8 = new BinaryTree.Node(1);
		
		root.addLeft(node1);
		root.addRight(node3);
		node1.addLeft(node2);
		node1.addRight(node6);
		node2.addLeft(node4);
		node2.addRight(node5);
		
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(BinaryTree.Node root) {
		if(root == null) return true;
		
		int l = getLength(root.getLeft());
		int r = getLength(root.getRight());
		return (l != -1 && r != -1);
	}

	private static int getLength(Node root) {
		if(root == null) return 0;
		int l = getLength(root.getLeft());
		int r = getLength(root.getRight());
		if(l == -1 || r == -1) {
			return -1;
		} else if(l == r || l == (r+1) || (l+1) == r) {
			return Math.max(l+1, r+1);
		}
		return -1;
	}

}
