package com.main.crackingcodinginterview.model;

public class BinaryTree {
	public Node root;
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public static void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void addLeft(Node node) {
			this.left = node;
		}
		
		public void addRight(Node node) {
			this.right = node;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public Node getRight() {
			return right;
		}
	}
	

}
