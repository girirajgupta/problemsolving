package com.main.crackingcodinginterview.chapter16;

public class EnglishPhrase {
	/*
	 * English Int: Given any integer, print an English phrase that describes the integer (e.g., "One Thousand,
Two Hundred Thirty Four").
	Hints: #502, #588, #688
	 */

	public static void main(String[] args) {
		System.out.println(getEnglishPhrase(1));
		System.out.println(getEnglishPhrase(10));
		System.out.println(getEnglishPhrase(100));
		System.out.println(getEnglishPhrase(1000));
		System.out.println(getEnglishPhrase(10000));
		System.out.println(getEnglishPhrase(100000));
		System.out.println(getEnglishPhrase(1000000));
		System.out.println(getEnglishPhrase(10000000));
		System.out.println(getEnglishPhrase(100000000));
		System.out.println(getEnglishPhrase(1000000000));
		System.out.println(getEnglishPhrase(1234));
		System.out.println(getEnglishPhrase(1214));
		System.out.println(getEnglishPhrase(12345));
		System.out.println(getEnglishPhrase(123456));
		System.out.println(getEnglishPhrase(1234567));
		System.out.println(getEnglishPhrase(12345678));
		System.out.println(getEnglishPhrase(123456789));
		System.out.println(getEnglishPhrase(1234567890));
	}

	private static String getEnglishPhrase(int number) {
		StringBuilder phrase = new StringBuilder();
		phrase.append(number).append(":");
		// divide by crore
		int result = number / 10000000;
		appendResult(phrase, result, "crore");
		result = number % 10000000;
		appendResult(phrase, result / 100000, "lac");
		result = number % 100000;
		appendResult(phrase, result / 1000, "thousands");
		result = number % 1000;
		appendResult(phrase, result / 100, "hundred");
		result = number % 100;
		if(result > 19) {
			appendResult(phrase, getTensValue(result / 10));
			result = number % 10;
		}
		appendResult(phrase, getUnitsValue(result));
		return phrase.toString();
	}

	private static void appendResult(StringBuilder phrase, int result, String value) {
		if (result > 0) {
			phrase.append(result).append(" ").append(value).append(" ");
		}
	}

	private static String getTensValue(int value) {
		switch (value) {
		case 2:
			return "Twenty";
		case 3:
			return "Thirty";
		case 4:
			return "Fourty";
		case 5:
			return "Fifty";
		case 6:
			return "Sixty";
		case 7:
			return "Seventy";
		case 8:
			return "Eighty";
		case 9:
			return "Ninety";
		default:
			return "";
		}
	}

	private static String getUnitsValue(int value) {
		switch(value) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Fife";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		default :
			return "";
		}
	}

	private static void appendResult(StringBuilder phrase, String value) {
		if (!value.isEmpty()) {
			phrase.append(value).append(" ");
		}
	}

}
