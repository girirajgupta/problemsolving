package com.test;

public class LCA {
	
	public static void main(String[] args) {
		

	}
	
	static Node findLCA(Node root, int data1, int data2) {
		if(root == null) {
			return null;
		}
		if(root.data > Math.max(data1, data2)) {
			return findLCA(root.left, data1, data2);
		} else if(root.data < Math.min(data1, data2)) {
			return findLCA(root.right, data1, data2);
		} else {
			return root;
		}
	}
	
	
	static class Node {
		public Node left;
		public Node right;
		public int data;
	}

}
