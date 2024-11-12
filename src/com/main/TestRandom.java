package com.main;

import com.offbytwo.ulid.ULID;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestRandom {
    static DecimalFormat df = new DecimalFormat("#.#################");
    static Random rd = new Random(System.currentTimeMillis());
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    static ULID ulid =new ULID();
    public static Random random = new Random();
    public static void main(String[] args) {
        Set s = new HashSet<String>();
        long start = System.nanoTime();
        int i  =0;
        while(i++<100000) {
            //s.add(getRandom2());
            getRandom2();
        }
        System.out.println("Time taken random2:: " + (System.nanoTime()-start));
        System.out.println("Time taken random2 count:: " + s.size());
        s.clear();
        i  =0;
        start = System.nanoTime();
        while(i++<100000) {
            //s.add(getRandom());
            getRandom();
        }
        System.out.println("Time taken random:: " + (System.nanoTime()-start));
        System.out.println("Time taken random count:: " + s.size());
        s.clear();
        i  =0;
        start = System.nanoTime();
        while(i++<100000) {
            //s.add(getRandom3());
            getRandom3();
        }
        System.out.println("Time taken random3:: " + (System.nanoTime()-start));
        System.out.println("Time taken random3 count:: " + s.size());
        s.clear();
        i  =0;
        start = System.nanoTime();
        while(i++<100000) {
            //s.add(getRandom5());
            getRandom5();
        }
        System.out.println("Time taken random4:: " + (System.nanoTime()-start));
        System.out.println("Time taken random4 count:: " + s.size());
        s.clear();
        i  =0;
        start = System.nanoTime();
        while(i++<100000) {
            //s.add(getRandom4());
            getRandom4();
        }
        System.out.println("Time taken random5:: " + (System.nanoTime()-start));
        System.out.println("Time taken random5 count:: " + s.size());
        s.clear();
        i  =0;
        start = System.nanoTime();
        while(i++<100000) {
            //s.add(getRandom6());
            getRandom6();
        }
        System.out.println("Time taken random6:: " + (System.nanoTime()-start));
        System.out.println("Time taken random6 count:: " + s.size());
        s.clear();
        i  =0;
        start = System.nanoTime();
        while(i++<100000) {
            //s.add(getRandom7());
            getRandom7();
        }
        System.out.println("Time taken random7:: " + (System.nanoTime()-start));
        System.out.println("Time taken random7 count:: " + s.size());
        s.clear();
    }

    public static String getRandom() {
        return TestRandom.class.getSimpleName() + ("_" + Math.random()).replace(".", "");
    }

    public static String getRandom2() {
        return TestRandom.class.getSimpleName() + ("_" + Math.random()).replace(".", "").replace("-","");
    }

    public static String getRandom3() {
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            int index = rd.nextInt(CHARACTERS.length());
            rd.ints(16,0,16);
            sb.append(CHARACTERS.charAt(index));
        }
        return TestRandom.class.getSimpleName() + ("_" + sb);
    }

    public static String getRandom4() {
        return TestRandom.class.getSimpleName() + ("_" + String.format("%.15f", Math.random()).replace(".", ""));
    }

    public static String getRandom5() {
        return TestRandom.class.getSimpleName() + ("_" + df.format(Math.random())).replace(".","");
    }

    public static String getRandom6() {
        return TestRandom.class.getSimpleName() + ("_" + new BigDecimal(Math.random()).toPlainString().replace(".", ""));
    }

    public static String getRandom7() {
        return TestRandom.class.getSimpleName() + ("_" + ulid.nextULID());
    }
}
