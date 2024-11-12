package com.main.crackingcodinginterview.chapter8;

public class TripleStep {
    public static void main(String[] args) {
        System.out.println("steps needed are :" + steps(8));
    }

    static int steps(int n) {
        int[] memory = new int[n];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        memory[3] = 4;
        return steps(n, memory);
    }

    static int steps(int n, int[] memory) {
        if(n <=3) {
            return memory[n];
        } else {
            return steps(n-1, memory) + 1 + steps(n-2, memory) + 2 + steps(n-3, memory) + 4;
        }
    }
}
