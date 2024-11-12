package com.main.crackingcodinginterview.chapter3;

public class StackMin {
    /*
    How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
Hints: #27, #59, #78
     */
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(12);
        System.out.println(myStack.getMin());
        myStack.push(10);
        System.out.println(myStack.getMin());
        myStack.push(20);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
    }

    public static class Stack<T extends Comparable> {
        private StackNode<T> top;

        public void push(T data) {
            if (top == null) {
                top = new StackNode<>(data, data);
            } else {
                T newMin = (top.getMinData().compareTo(data) < 0) ? top.getMinData() : data;
                final StackNode<T> node = new StackNode<>(data, newMin);
                node.setNext(top);
                top = node;
            }
        }

        public T getMin() {
            return top.getMinData();
        }

        public T pop() {
            final StackNode<T> node = top;
            top = top.getNext();
            return node.getData();
        }

        private class StackNode<T extends Comparable> {
            T data;
            T minData;
            StackNode<T> next;

            public StackNode(T data, T minData) {
                this.data = data;
                this.minData = minData;
            }

            public T getData() {
                return data;
            }

            public T getMinData() {
                return minData;
            }

            public StackNode<T> getNext() {
                return next;
            }

            public void setNext(StackNode<T> next) {
                this.next = next;
            }
        }
    }
}
