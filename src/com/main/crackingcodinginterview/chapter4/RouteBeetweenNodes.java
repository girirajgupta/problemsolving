package com.main.crackingcodinginterview.chapter4;

import java.util.LinkedList;
import java.util.Queue;

import com.main.crackingcodinginterview.model.Graph;

public class RouteBeetweenNodes {
/*
 * 	Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
	route between two nodes.
	Hints: #127
 */
	public static void main(String[] args) {
		Graph.Node node2 = new Graph.Node("B");
		Graph.Node node1 = new Graph.Node("A");
		Graph.Node node3 = new Graph.Node("C");
		Graph.Node node4 = new Graph.Node("D");
		Graph.Node node5 = new Graph.Node("E");
		Graph.Node node6 = new Graph.Node("F");
		node1.addChild(node2);
		node2.addChild(node3);
		node3.addChild(node4);
		node1.addChild(node5);
		node5.addChild(node6);
		node2.addChild(node5);
		Graph graph = new Graph(new Graph.Node[]{node1, node2, node3, node4});
		//System.out.println(routeExists(graph, node1, node5));
		System.out.println(BFS(node2, node6));
	}
	
	public static boolean routeExists(Graph graph, Graph.Node node1, Graph.Node node2) {
		return DFS(node1, node2);
	}
	
	public static boolean DFS(Graph.Node node1, Graph.Node node2) {
		if (node1 == null || node2 == null) return false;
		
		if(node1.name == node2.name) {
			node1.visited = true;
			return true;
		}
		boolean found= false;
		for(Graph.Node node : node1.children) {
			if (node.visited == false) {
				found = DFS(node, node2);
				if(found)  {
					break;
				}
			}	
		}
		return found;
	}
	
	public static boolean BFS(Graph.Node node1, Graph.Node node2) {
		if (node1 == null || node2 == null) return false;
		boolean found = false;
		Queue<Graph.Node> queue = new LinkedList<>();
		queue.add(node1);
		for(Graph.Node child : node1.children) {
			queue.add(child);
		}
		while(!queue.isEmpty()) {
			Graph.Node curNode = queue.poll();
			if(curNode.visited == false) {
				if(curNode.name == node2.name) {
					found = true;
					break;
				}
				for(Graph.Node child : curNode.children) {
					queue.add(child);
				}
				curNode.visited = true;
			}
		}
		
		return found;
	}
}
