package com.main.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastTime(new char[]{'A','A','B','B'},2)); //5
        System.out.println(leastTime(new char[]{'A','K','X','M','W','D','X','B','D','C','O','Z','D','E','Q'},3));  //15
        System.out.println(leastTime(new char[]{'R','A','X','E','E','Z','F','Q','R','S','G','G','O','T','N','L','A','B','V','J','M','B','E','O','H','V','J','D','B','B','G','L','I','W','X','B','Q','C','U','D','Q','B','G','O','A','R','I','W','R','O','U','U','Z','L','C','Q','K','W','Z','P','N','L','U','B','R','F','J','L','J','J','K','G','E','W','B','Z','L','U','U','Z','J','Z','X','Z','D','U','K','L','W','R','R','I','T','Z','I','G','H','I','N','F','B','F','J','B','R','G','N','G','S','X','R','Q','Z','N','O','Y','Y','W','K','U','O','F','H','J','L','D','N','H','J','P','U','N','V','M','N','P','F','P','S','L','W','J','H','Y','T','A','K','G','S','M','I','O','S','X','Z','V','W','Y','Y','Y','N','Z','K','R','I','V','E','Z','H','C','V','L','L','G','F','J','N','J','D','A','C','U','H','M','S','J','C','T','H','F','M','Z','Q','H','Z','C','D','H','B','L','V','C','K','Q','O','R','M','K','H','X','G','F','O','U','N','C','I','O','H','X','T','E','D','G','X','Q','P','P','I','C','M','B','J','D','F','L','X','T','O','Z','V','O','T','Z','U','E','V','F','I','O','M','N','K','J','C','X','Z','E','R','S','D','V','M','X','C','Y','E','Y','Z','C','C','U','P','C','E','E','D','A','T','C','P','C','Z','I','A','R','T','D','E','V','V','O','E','R','B','M','C','R','V','M','T','I','R','Z','L','F','L','V','B','Q','N','Y','P','H','T','O','T','O','O','R','N','L','D','K','J','O','N','B','W','U','D','R','F','V','T','L','S','E','A','G','D','S','Q','D','G','U','L','V','Q','H','Y','P','S','Y','S','R','A','E','G','O','D','B','U','F','F','S','F','V','Z','I','V','B','Q','K','F','S','D','H','L','P','H','K','R','S','R','S','D','X','T','C','M','G','Q','A','I','X','G','X','P','F','Q','N','M','U','V','X','X','S','L','H','Y','S','U','S','Y','V','W','P','O','E','Z','R','A','C','N','P','B','I','H','R','D','W','J','X','O','W','L','G','R','C','P','I','A','V','T','O','Z','J','U','Q','P','S','K','S','K','I','A','T','S','C','H','X','D','A','D','N','I','M','J','C','H','O','P','P','W','W','Z','I','I','H','S','B','S','Z','B','O','A','C','D','J','U','T','F','M','H','A','J','X','X','F','Z','S','K','R','I','N','X','O','K','F','V','Y','X','Q','Z','J','L','C','M','J','Z','A','J','H','W','Z','M','A','I','Y','W','Z','R','U','H','M','D','G','L','M','J','U','D','G','W','C','F','I','Q','Y','E','W','E','W','L','G','G','T','L','O','D','I','V','M','E','H','F','C','N','V','U','Y','S','C','Q','R','T','I','Y','L','M','J','P','H','H','P','Z','D','B','O','K','C','I','M','D','O','V','A','O','O','E','P','M','H','Y','U','F','G','D','V','N','N','K','T','O','U','L','P','X','N','Z','Y','Y','J','O','B','P','A','X','T','M','S','Y','P','I','F','Q','W','B','Z','O','V','C','R','M','B','T','S','H','P','I','U','P','C','C','X','X','H','V','O','S','V','P','W','J','S','J','I','H','C','W','B','M','B','H','G','Y','U','I','O','R','F','C','B','S','F','Z','C','I','R','T','U','N','E','U','W','S','O','P','B','I','T','Q','V','P','H','V','P','Y','J','A','L','R','S','I','M','L','U','Y','K','G','X','A','J','A','Y','V','L','X','B','H','T','K','I','Z','D','B','N','R','H','I','F','R','Z','G','C','K','Q','Y','M','D','I','Y','D','E','F','R','M','Y','P','S','U','H','V','U','U','C','B','M','U','N','D','C','D','B','B','U','L','B','M','E','R','Q','A','P','J','F','M','N','H','S','L','A','T','S','W','H','J','X','D','F','G','F','H','J','W','N','W','J','D','N','J','E','X','R','Q','P','Z','U','D','M','J','C','V','U','L','F','S','X','Z','U','M','O','F','Y','V','X','T','C','H','P','B','K','J','U','S','K','U','K','Q','E','M','R','I','D','H','H','U','L','N','X','T','H','D','H','S','D','U','U','N','Q','Y','R','W','C','R','F','E','C','M','K','T','A','J','I','B','R','O','N','F','E','N','N','S','W','P','N','D','V','W','D','H','J','U','W','O','E','E','B','Q','Y','R','F','K','E','E','G','Z','Y','O','D','S','F','X','D','T','H','B','J','G','P','Z','W','I','H','W','C','W','I','R','Z','U','Q','M','A','R','F','M','T','R','K','L','U','E','I','T','X','S','E','Q','H','T','K','Z','I','N','P','F','N','G','P','G','A','H','O','W','T','Q','F','F','S','A','M','Q','I','G','Y','O','M','B','S','W','S','Q','T','C','A','Z','B','H'},13));
       System.out.println(leastTime(new char[]{'A','B','C','A','B','D','A','E','F','A','H','I'},2));

    }
    public static int leastTime(char[] tasks, int n) {
                int[] map = new int[26];
                for (char c: tasks)
                    map[c - 'A']++;
                Arrays.sort(map);
                int max_val = map[25] - 1, idle_slots = max_val * n;
                for (int i = 24; i >= 0 && map[i] > 0; i--) {
                    idle_slots -= Math.min(map[i], max_val);
                }
                return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    public static int leastTime2(char[] tasks, int n) {
        if (n ==1) {
            return  tasks.length;
        }
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for(char task : tasks) {
            counts.put(task, counts.getOrDefault(task,0)+1);
        }

        final List<Character> sTasks = counts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(e -> e.getKey()).collect(Collectors.toList());

        //counts.entrySet().stream().forEach(System.out::println);
        sTasks.stream().forEach(e->System.out.println(e + "=" + counts.get(e)));
        int minC =0;
        int tv = 0;
        int i=0,k=0;
        List<Character> order = new ArrayList<>(tasks.length);
        while(k<sTasks.size()) {
            char t = sTasks.get(k);
            int count = counts.get(t);
            if(count != 0) {
                tv++;
                order.add(t);
                minC++;
                int j=0;
                i = k+1;
                while(j<(n) && i < sTasks.size()) {
                    char t2 = sTasks.get(i);
                    int count2 = counts.get(t2);
                    if(count2 != 0) {
                        tv++;
                        order.add(t2);
                        counts.put(t2, count2-1);
                        j++;
                        minC++;
                    }
                    i++;
                }
                if(j<(n) && tv != tasks.length) {
                    order.add('I');
                    minC = minC + (n-j);
                }
                counts.put(t, count-1);
            } else {
                k++;
            }
        }
        order.stream().forEach(System.out::println);

        return minC;
    }
}
