package com.main.code360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/*
There are ‘N’ people numbered from 0 to N - 1, standing in a queue. You are given two arrays ‘Height’ and ‘Infront‘ consisting of ‘N’ non-negative integers. ‘Height[i]’ gives the height of the ith person, and ‘Infront[i]’ gives the number of persons who are taller than the ith person and standing in front of the ith person.

Your task is to find out the actual order of people in a queue. You should print ‘N’ integers where the ‘ith’ integer is the height of the person who should be at the ith position from the start of the queue.

Note :

1. Consider that all elements in array ‘Height’ are unique.
2. It is guaranteed that a valid order always exists for the given array ‘Height’ and ‘Infront’.
Example :

Let there are 6 people, their heights are given by array  ‘Height’ :  [5, 3, 2, 6, 1, 4],  and the number of people in front of them is given by array ‘Infront’: [0, 1, 2, 0, 3, 2]

Thus the actual order of people’s height in the queue will be [5, 3, 2, 1, 6, 4]

In this order, the first person in a queue i.e a person with a height of 5, has no person in front of them who is taller than him.
The second person in a queue i.e a person with a height of 3 has 1 person (person with height 5) in front of them who is taller than him.
The third person in a queue i.e a person with a height of 2 has 2 people (people with height 5 and 3) in front of them who are taller than him.
The fourth person in a queue i.e a person with a height of 1 has 3 people (people with height 5, 3, 2) in front of them who are taller than him.
The fifth person in a queue i.e a person with a height of 6 has no person in front of them who is taller than him.
The sixth person in a queue i.e a person with a height of 4 has 2 people (people with height 5, and 6) in front of them who are taller than him.

We can observe this is the only possible order that is possible according to the array ‘Infront’.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 50
1  <= N <=  10^4
1 <= Height[i] <= 10^9
0 <= Infront[i] < ‘N’

Where ‘T’ is the total number of test cases, ‘N’ is the number of people in the queue, Height[i], and Infront[i] respectively are height and number of people in front of ith who are taller than him.

Time limit: 1 sec
Sample Input 1 :
2
5
5 4 3 2 1
0 0 0 0 0
6
5 3 2 6 1 4
0 1 2 0 3 2
Sample Output 1 :
1 2 3 4 5
5 3 2 1 6 4
Explanation Of Sample Input 1 :
Test case 1:
There is no person in front of any person who is taller than him, Thus all of them must be present in the queue in increasing order of their height.

Test case 2:
See the problem statement for an explanation.
Sample Input 2 :
2
2
2 3
1 0
5
1 2 3 4 5
4 3 2 1 0
Sample Output 2 :
3 2
5 4 3 2 1

 */
public class OrderHeight {
    public static void main(String[] args) {
        //findOrder(Arrays.asList(5, 3, 2, 6, 1, 4), Arrays.asList(0, 1, 2, 0, 3, 2)).forEach(System.out::println);
        findOrder(Arrays.asList(1 ,2, 3, 4 ,5), Arrays.asList(4, 3 ,2, 1, 0)).forEach(System.out::println);
    }
    public static List<Integer> findOrder(List<Integer> height, List<Integer> infront) {
        List<Integer> results = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();
        int index=0;
        for(int i=0; i< height.size();i++) {
            int inf = infront.get(i);
            if(queue.size() == 0) {
                if(inf == 0) {
                    results.add(height.get(i));
                    queue.add(height.get(i));
                } else {
                    results.add(-1);
                    index = 0;
                    results.add(height.get(i));
                }
            } else {
                if(queue.peek() > height.get(i) && queue.size() == infront.get(i)) {
                    queue.add(height.get(i));
                    results.add(height.get(i));
                } else if (queue.peek() > height.get(i) && queue.size() > infront.get(i)) {
                    queue.add(height.get(i));
                    while(results.size() > infront.get(i)) {
                        int top = results.get(results.size()-1);
                        int depth = 1;
                        if(top > height.get(i)) {
                            results.remove(results.size() - depth);
                        }
                        depth++;
                        stack.add(top);
                    }
                    results.add(height.get(i));
                    while(!stack.isEmpty()) {
                        results.add(stack.pop());
                    }
                }
                else if(inf == 0){
                    queue.add(height.get(i));
                    results.add(height.get(i));
                } else {

                    queue.add(height.get(i));
                    results.add(height.get(i));
                }
            }

        }
        return results;
    }
}
