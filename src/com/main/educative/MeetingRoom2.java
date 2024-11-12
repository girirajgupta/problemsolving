package com.main.educative;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        System.out.println(findSets(new int[][]{ {2,8},{3,4},{3,9},{5,11},{8,20},{11,15}}));
    }
    public static int findSets(int[][] intervals) {
        // sort

        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;
        for(int i = 0; i < intervals.length; i++){
            pq.offer(intervals[i][1]);
            if(intervals[i][0] < pq.peek())  room++;
            else{
                pq.poll();
            }
        }
        return room;
    }
}
