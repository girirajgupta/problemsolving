package com.main.pub;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheNew {
    public static void main(String[] args) {
        DoublyLinkedList dl_List = new DoublyLinkedList();
        //Add nodes to the list
        final DoublyLinkedList.Node node =  dl_List.addNode(10,1);
        dl_List.addNode(20,2);
        dl_List.addNode(30,3);
        dl_List.addNode(40,4);
        dl_List.addNode(50,5);

        //print the nodes of DoublyLinkedList
        dl_List.printNodes();
        dl_List.removeLast();
        //dl_List.removeNode(node);
        dl_List.printNodes();


        LRUC cache = new LRUC(4);
        cache.addToCache(1,1);
        cache.addToCache(2,1);
        cache.addToCache(3,1);
        cache.print();
        cache.addToCache(4,1);
        cache.addToCache(5,1);
        cache.addToCache(6,1);
        cache.print();
        cache.get(3);
        cache.get(4);
        cache.print();
        cache.addToCache(1,1);
        cache.print();
    }
    static class LRUC {
       Map<Integer, DoublyLinkedList.Node> map = new HashMap<>();
       DoublyLinkedList list = new DoublyLinkedList();
       int capacity;
       public LRUC(int capacity) {
           this.capacity = capacity;
       }

       public void addToCache(int key, int value) {
           DoublyLinkedList.Node node = null;
           if(map.containsKey(key)) {
               node = map.get(key);
               list.removeNode(node);
           } else if (map.size() == capacity) {
               node = list.removeLast();
               map.remove(node.key);
           }
           node = list.addNode(key, value);
           map.put(key, node);
       }

       public int get(int key) {
           if(map.containsKey(key)) {
               DoublyLinkedList.Node node = map.get(key);
               list.removeNode(node);
               node = list.addNode(key, node.value);
               map.put(key, node);
               return node.value;
           } else {
               return -1;
           }
       }

       public void print() {
           list.printNodes();
       }
    }

    static class DoublyLinkedList {
        //A node class for doubly linked list
        class Node{
            int key;
            int value;
            Node previous;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        //Initially, heade and tail is set to null
        Node head, tail = null;

        public void removeNode(Node node) {
            if (node.previous != null) {
                node.previous.next = node.next;
            } else {
                head = node.next;
            }
            if(node.next != null) {
                node.next.previous = node.previous;
            } else {
                tail = node.previous;
            }
            node.previous = null;
            node.next = null;
        }

        public Node removeLast() {
            Node node = head;
            if (head != null && head.next != null) {
                head = head.next;
                head.previous = null;
            } else if (head != null) {
                head = null;
            }
            return node;
        }

        //add a node to the list
        public Node addNode(int item, int value) {
            //Create a new node
            Node newNode = new Node(item, value);

            //if list is empty, head and tail points to newNode
            if(head == null) {
                head = tail = newNode;
                //head's previous will be null
                head.previous = null;
                //tail's next will be null
                tail.next = null;
            }
            else {
                //add newNode to the end of list. tail->next set to newNode
                tail.next = newNode;
                //newNode->previous set to tail
                newNode.previous = tail;
                //newNode becomes new tail
                tail = newNode;
                //tail's next point to null
                tail.next = null;
            }

            return newNode;
        }

        //print all the nodes of doubly linked list
        public void printNodes() {
            //Node current will point to head
            Node current = head;
            if(head == null) {
                System.out.println("Doubly linked list is empty");
                return;
            }
            System.out.println("Head of doubly linked list: " + ((head!=null) ? head.key : null));
            System.out.println("tail of doubly linked list: " + ((tail!= null) ? tail.key : null));
            System.out.println("Nodes of doubly linked list: ");
            while(current != null) {
                //Print each node and then go to next.
                System.out.print(current.key + " ");
                current = current.next;
            }
            System.out.println("");
        }
    }
}
