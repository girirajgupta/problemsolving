package com.main.crackingcodinginterview.chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given arrival and departure times of all trains that reach a railway station.
Your task is to find the minimum number of platforms required for the railway station
so that no train waits.

Note: Consider that all the trains arrive on the same day and leave on the same day.
Also, arrival and departure times will not be same for a train,
but we can have arrival time of one train equal to departure of the other.
In such cases, we need different platforms,
i.e at any given instance of time, same platform can not be used for
both departure of a train and arrival of another.

Input:
The first line of input contains T, the number of test cases.
For each test case, first line will contain an integer N, the number of trains.
Next two lines will consist of N space separated time intervals denoting arrival and
departure times respectively.
Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM ,
where the first two charcters represent hour (between 00 to 23 ) and
last two characters represent minutes (between 00 to 59).

Output:
For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] < D[i] <= 2359
*/
public class MinPlatform {
    private static Set<Integer> seen = new HashSet<>();
    private static Map<String,Integer> counts = new HashMap<>();
    public static void getMinPlatforms(List<TrainInfo> trains) {
        int numOfPlatforms = 1;
        for (int i=0;i< trains.size();i++) {
            if(!seen.contains(i)) {
                numOfPlatforms += getOverlapping(trains, i);
            }
        }
        System.out.println(numOfPlatforms);
    }

    public static void getMinPlatforms2(List<TrainInfo> trains) {
        int minPlatform = 0;
        for (int i=0;i< trains.size();i++) {
            minPlatform = get(trains, i , minPlatform);
        }
        System.out.println(minPlatform);
    }

    public static int get(List<TrainInfo> trains, int index, int minSoFar) {
        int newMin = minSoFar;
        TrainInfo info = trains.get(index);
        int hr = info.arrival_hr;
        int min = info.arrival_mins;
        while ( (hr < info.dep_hr)  ||  ( hr == info.dep_hr && min <= info.dep_mins)) {
            String hash = "" + hr + min;
            int count=-1;
            if (counts.containsKey(hash)) {
                count = counts.get(hash) + 1;
                counts.put(hash,count);
            } else {
                count=1;
                counts.put(hash,1);
            }
            if (count > newMin) {
                newMin = count;
            }

            hr = hr + (min+10)/60;
            min = (min+10) % 60;
        }

        return  newMin;
    }

    private static int getOverlapping(final List<TrainInfo> trains, final int index) {
        TrainInfo arrivedTrain = trains.get(index);
        int requiredPlatforms = 0;
        for (int i=index+1;i< trains.size();i++) {
            TrainInfo arrivingTrain = trains.get(i);
            if (arrivedTrain.overlaps(arrivingTrain)) {
                requiredPlatforms++;
                seen.add(i);
            }
        }
        return requiredPlatforms;
    }

    public static void main(String args[]) {
        List<TrainInfo> trains = new ArrayList<>();

        trains.add(new TrainInfo("t1",9,0,10,0));
        trains.add(new TrainInfo("t2",9,10,10,20));
        trains.add(new TrainInfo("t3",10,10,10,50));
        trains.add(new TrainInfo("t4",11,0,12,0));

        getMinPlatforms2(trains);
        trains.clear();
        counts.clear();
        trains.add(new TrainInfo("t1",9,0,10,0));
        trains.add(new TrainInfo("t2",9,10,11,30));
        trains.add(new TrainInfo("t3",9,20,10,50));
        trains.add(new TrainInfo("t5",10,20,10,50));
        trains.add(new TrainInfo("t4",11,0,12,0));

        getMinPlatforms2(trains);
    }

    public static class TrainInfo {
        String name;
        int arrival_hr;
        int arrival_mins;
        int dep_hr;
        int dep_mins;
        boolean seen;
        public TrainInfo(String name, int arrival_hr, int arrival_mins, int dep_hr, int dep_mins) {
            this.arrival_hr = arrival_hr;
            this.arrival_mins = arrival_mins;
            this.dep_mins = dep_mins;
            this.dep_hr = dep_hr;
            this.name = name;
            this.seen = false;
        }

        public void setSeen(boolean seen) {
            this.seen = seen;
        }

        public boolean overlaps(TrainInfo arrivingTrain) {
            if (arrivingTrain.arrival_hr == arrival_hr && arrivingTrain.arrival_hr == dep_hr) {
                return arrivingTrain.arrival_mins >= arrival_mins && arrivingTrain.arrival_mins <= dep_mins;
            } else if (arrivingTrain.arrival_hr == arrival_hr && arrivingTrain.arrival_hr < dep_hr) {
                return true;
            } else if (arrivingTrain.arrival_hr > arrival_hr && arrivingTrain.arrival_hr < dep_hr) {
                return true;
            } else if (arrivingTrain.arrival_hr > arrival_hr && arrivingTrain.arrival_hr == dep_hr) {
                return arrivingTrain.arrival_mins <= dep_mins;
            } else {
                return false;
            }
        }
    }
}
