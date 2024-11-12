package com.main.crackingcodinginterview.chapter2;

import com.main.crackingcodinginterview.model.Node;
import com.main.crackingcodinginterview.model.NodeHelper;

public class SumLists {
    /*
    You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .That is,617 + 295.
Output: 2 -) 1 -) 9. That is, 912.
     */
    public static void main(String[] args) {
        NodeHelper.printList(getSum(NodeHelper.getLinkedList(new int[]{9,7,8}),
                                    NodeHelper.getLinkedList(new int[]{6,8,5})));
    }

    private static Node getSum(Node node1, Node node2) {
        Node result = null;
        Node current = null;
        int carry = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.getData() + node2.getData();
            int value = (sum % 10) + carry ;
            carry = sum / 10;
            Node newNode = new Node(value);
            if(result == null) {
                result = newNode;
                current = result;
            } else {
                current.setNext(newNode);
                current = newNode;
            }
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
        if (node1 != null) {
            addRemaining(current, node1, carry);
        } else if (node2 != null) {
            addRemaining(current, node2, carry);
        } else if (carry > 0) {
            current.setNext(new Node(carry));
        }

        return result;
    }

    private static void addRemaining(Node current, Node node, int carry) {
        while(node != null) {
            int sum = node.getData()+carry;
            int value = sum % 10;
            carry = sum / 10;
            current.setNext(new Node(value));
            node = node.getNext();
            current = current.getNext();
        }
        if (carry > 0) {
            current.setNext(new Node(carry));
        }
    }
}
