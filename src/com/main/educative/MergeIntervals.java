package com.main.educative;

import java.util.HashMap;
import java.util.Map;

public class MergeIntervals {
    public static void main(String[] args) {
       // print(mergeIntervals(new int[][]{{1,5},{3,7},{4,6}}));
        print(mergeIntervals(new int[][]{{1,5},{4,6},{6,8},{11,15}}));
    }
    public static int[][] mergeIntervals(int[][] intervals) {
        Map<Integer, Integer> outputs = new HashMap<>();
        outputs.put(intervals[0][0],intervals[0][1]);
        int current=intervals[0][0];
        for(int i=1; i< intervals.length;i++) {
            if(intervals[i][0] >= current &&  intervals[i][0] <= outputs.get(current)) {
                if(intervals[i][1] > outputs.get(current)) {
                    outputs.put(current, intervals[i][1]);
                }
            } else {
                outputs.put(intervals[i][0], intervals[i][1]);
                current = intervals[i][0];
            }
        }
        return outputs.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .toArray(int[][]::new);
    }

    private static void print(int[][] output) {
        for(int i=0; i< output.length;i++) {
            for(int j=0; j <output[i].length; j++ ) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
