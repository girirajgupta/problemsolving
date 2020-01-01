package com.main.pub;

public class DivCount {

	public static void main(String[] args) {
		System.out.println(solution(11,345,17));
		System.out.println(solution2(0,10,3));
		System.out.println(solution3(11,345,17));
	}
	
	public static int solution(int A, int B, int K) {
       int diff = B - A;
       int count = diff/K;
       if(A % K == 0 ) {
    	   count += 1;
       }
       if(B%K == 0) {
    	   count +=1;
       }
       
       return count;
    }
	
	public static int solution2(int A, int B, int K) {
		int count =0;
		for(int i=A; i< B; i++) {
			if(i % K == 0) {
				count++;
			}
		}
		
		return count;
	}
	
	public static int solution3(int A, int B, int K) {
		int count = 0;
		count = B/K;
		count = count - A/K;
		return count;
	}
	

}
