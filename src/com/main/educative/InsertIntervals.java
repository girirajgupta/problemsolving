package com.main.educative;

import java.util.LinkedHashMap;
import java.util.Map;

public class InsertIntervals {
    public static void main(String[] args) {
        //print(insertInterval(new int[][]{{2,3},{4,6},{6,8},{11,15}}, new int[]{1,5}));
        print(insertInterval(new int[][]{{1,6},{8,9},{10,15},{16,18}}, new int[]{9,10}));

    }
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int current;
        int j=1;
        Map<Integer, Integer> outputs = new LinkedHashMap<>();
        boolean newSet = false;
        if(newInterval[0] < intervals[0][0]) {
            newSet = true;
            outputs.put(newInterval[0], newInterval[1]);
            current = newInterval[0];
            j=0;
        } else {
            outputs.put(intervals[0][0],intervals[0][1]);
            current = intervals[0][0];
        }

        for(int i = j;i< intervals.length;i++) {
            if(!newSet) {
                if(newInterval[0] >= current &&  newInterval[0] <= outputs.get(current)) {
                    if(newInterval[1] > outputs.get(current)) {
                        outputs.put(current, newInterval[1]);
                        newSet = true;
                    }
                } else if(newInterval[0] < intervals[i][0]){
                    outputs.put(newInterval[0],newInterval[1]);
                    newSet = true;
                    current = newInterval[0];
                }
            }
            if(intervals[i][0] >= current &&  intervals[i][0] <= outputs.get(current)) {
                if(intervals[i][1] > outputs.get(current)) {
                    outputs.put(current, intervals[i][1]);
                }
            } else {
                outputs.put(intervals[i][0], intervals[i][1]);
                current = intervals[i][0];
            }
        }

        if(!newSet) {
            outputs.put(newInterval[0], newInterval[1]);
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
