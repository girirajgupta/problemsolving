package com.test;


import java.util.*;import java.util.stream.*;

class ParallelStreamTest {public static void main(String[] args) {// This is now a list of double values.
	ArrayList<Double> myList = new ArrayList<>( );
	myList.add(4.0);myList.add(4.0);myList.add(9.0);myList.add(16.0);
    double productOfSqrRoots = myList.parallelStream().reduce(1.0,(a,b) -> Math.sqrt(a) * Math.sqrt(b));
    System.out.println("Product of square roots: " + productOfSqrRoots);
    productOfSqrRoots = myList.stream().reduce(1.0,(a,b) -> a * Math.sqrt(b));
    System.out.println("Product of square roots:2 " + productOfSqrRoots);
    productOfSqrRoots = myList.stream().map((a) -> Math.sqrt(a)).reduce(1.0, (a,b)-> a*b);
    System.out.println("Product of square roots:3 " + productOfSqrRoots);
	}
}