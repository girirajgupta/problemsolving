package com.main.crackingcodinginterview.chapter4;

import com.main.crackingcodinginterview.model.BinaryTree;

public class MinimalBinarySearchTree {
/*
 * 	Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
	to create a binary search tree with minimal height.
	Hints: #19, #73, #116	
 */
	public static void main(String[] args) {
		BinaryTree.inOrder(getMinimalBinarySTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},0, 16));
	}
		
	public static BinaryTree.Node getMinimalBinarySTree(int[] a, int low, int high) {
		if(high <= low) {
			return null;
		}
		BinaryTree.Node root = null;
		int mid = (low+high)/2;
		root = new BinaryTree.Node(a[mid]);
		root.addLeft(getMinimalBinarySTree(a, low, mid));
		root.addRight(getMinimalBinarySTree(a, mid+1, high));
		return root;
	}
}
