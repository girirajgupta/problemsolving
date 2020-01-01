package com.main.pub;

public class Fibo {
	static int memo[] = {0,0,0,0,0,0,0,0,0,0};
	static int hit = 0;
	static int miss = 0;
	public static void main(String[] args) {

		for(int i =0 ; i < 10; i++) {
			System.out.println(String.format("Fib at postion %s is %s",i, fibo(i)));
			System.out.println(String.format("Fib2 at postion %s is %s",i, fibo2(i)));
			System.out.println(String.format("Total hit:%s and mist:%s",hit, miss));
		}
		/*System.out.println(String.format("Fib at postion %s is %s",1, fibo(1)));
		System.out.println(String.format("Fib at postion %s is %s",2, fibo(2)));
		System.out.println(String.format("Fib at postion %s is %s",3, fibo(3)));*/
	}
	
	private static int fibo(int position) {
		if(position == 0) {
			return 0;
		} else if (position == 1) {
			return 1;
		} else {
			return fibo(position-1) + fibo(position - 2);
		}
	}
	
	private static int fibo2(int position) {
		if(position == 0) {
			return 0;
		} else if (position == 1) {
			return 1;
		} else if (memo[position] != 0) {
			hit++;
			return memo[position];
		} else {
			miss++;
			int num = fibo2(position -1) + fibo2(position -2);
			memo[position] = num;
			return num;
		}
	}

}
