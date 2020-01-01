package com.test;

public class DartGame {

	public static void main(String[] args) {
		//String[] scores = {"D20", "T20", "T20", "T20", "T10", "1"};
		//String[] scores = {"D20", "T20", "T20", "T20", "T10", "1","T10","D10"};
		//String[] scores = {"D20", "T20", "T20", "T20", "T20", "T20","T10","10","1"};
		//String[] scores = {"D20", "T20", "T20", "20", "20", "20","T10","T20","1"};
		//String[] scores = {"D20", "T20", "T20", "D20", "20", "20","T10","T20","1"};
		//String[] scores = {"D20", "T20", "T20", "T20", "T10", "1", "20","15","0","T5"};
		//String[] scores = {"D20", "T20", "T20", "T20", "T10", "1", "D16","17"}; //50
		String[] scores = {"D20", "T20", "T20", "T20", "T10", "1", "DB"}; //0
		//String[] scores = {"20", "T20", "T20", "20", "T10", "D1"};
		System.out.println(getScore(scores));
	}
	
	static int getScore(String[] scores){
		int finalScore = 301;
		int previousRoundScore = finalScore;
		int numberOfThrowsInCurrentRound = 0;
		
		int startingIndex = goToStartingPoint(scores);
		if(startingIndex < 0) {
			return finalScore;
		}
		
		for(int i= startingIndex ; i< scores.length;) {
			numberOfThrowsInCurrentRound++;
			int currentScore = getCurrentScore(scores[i]);
			int tempScore = finalScore - currentScore;
			
			if(!busted(scores[i], tempScore)) {
				finalScore = tempScore;
				i++;
			} else {
				finalScore = previousRoundScore;
				i += (3 - numberOfThrowsInCurrentRound + 1);
				numberOfThrowsInCurrentRound = 0;
			}
			
			if(numberOfThrowsInCurrentRound == 3) {
				previousRoundScore = finalScore;
				numberOfThrowsInCurrentRound = 0;
			}
		}
		
		return finalScore;
	}

	private static int goToStartingPoint(String[] scores) {
		for(int i=0; i< scores.length; i++) {
			if(scores[i].startsWith("D")) {
				return i;
			}
		}
		
		return -1;
	}
	
	private static int getCurrentScore(String score) {
		if(score.equals("SB")) {
			return 25;
		} else if(score.equals("DB")) {
			return 50;
		} else if(score.startsWith("D")) {
			String value = score.substring(1);
			return Integer.valueOf(value) * 2;
		} else if(score.startsWith("T")) {
			String value = score.substring(1);
			return Integer.valueOf(value) * 3;
		} else {
			return Integer.valueOf(score);
		}
	}
	
	private static boolean busted(String score, int newScore) {
		if(!score.startsWith("D")) {
			return newScore <= 1;
		}
		
		return false;
	}

}
