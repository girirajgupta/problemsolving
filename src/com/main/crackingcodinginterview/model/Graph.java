package com.main.crackingcodinginterview.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	public Node[] nodes;
	
	public Graph(Node[] nodes) {
		this.nodes = nodes;
	}

	public static class Node {
		public String name;
		public List<Node> children;
		public boolean visited;
		
		public Node(String name) {
			this.name = name;
			children = new ArrayList<>();
		}
		
		public void addChild(Node child) {
			this.children.add(child);
		}
	}
}


