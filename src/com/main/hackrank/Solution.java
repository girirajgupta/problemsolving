package com.main.hackrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Result {

    /**
     * An entity to hold bin range details. A bin range is a pair of 12 digit numbers that
     * mark the boundaries of the range which is maped to other bin range properties such
     * as a card type. The range boundaries are inclusive.
     */
    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }

        public String toString() {
            return start + "," + end + "," + cardType + ".";
        }
    }

    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         *
         * @return the card type for this cardNumber or null if the card number does not
         *      fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }

    static class InmemoryCache implements CardTypeCache {
        private Map<String, String> cardCache = new HashMap<>();
        private Map<String, BinRange> ranges = new HashMap<>();
        private List<String> keys;
        private int maxLength = Integer.MAX_VALUE;

        public String get(String cardNumber) {
            cardNumber = cardNumber.substring(0,keys.get(0).length()-1);
            int low = 0;
            int high = keys.size();
            int mid;
            int result;
            while(low < high) {
                mid = low + (high - low)/2;
                result = keys.get(mid).compareTo(cardNumber);
                System.out.println("low:" + low);
                System.out.println("mid:" + mid);
                System.out.println("high:" + high);
                System.out.println("result:" + result);
                if(result == 0) {
                    return cardCache.get(keys.get(mid));
                } else if(result < 0 ) {
                    System.out.println("cardNumber:" + cardNumber);
                    BinRange range = ranges.get(keys.get(mid));
                    if(range.start.compareTo(cardNumber) < 0 && range.end.compareTo(cardNumber) > 0) {
                        return cardCache.get(keys.get(mid));
                    }
                    low = mid+1;
                } else {
                    System.out.println("cardNumber:" + cardNumber);
/*                    BinRange range = ranges.get(keys.get(mid));
                    if(range.start.compareTo(cardNumber) < 0 && range.end.compareTo(cardNumber) >= 0) {
                        return cardCache.get(keys.get(mid));
                    }*/
                    high = mid;
                }
            }

            return null;
        }

        public void buildIndex() {
            this.keys = cardCache.keySet().stream().sorted().collect(Collectors.toList());
            System.out.println(keys);
            System.out.println(cardCache);
            System.out.println(ranges);
        }

        public void add(String key, BinRange range) {
            cardCache.put(key, range.cardType);
            ranges.put(key, range);
        }
    }

    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     *
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        CardTypeCache cache = new InmemoryCache();
        for(BinRange range : binRanges) {
            String hash = getHash(range);
            ((InmemoryCache) cache).add(hash, range);
        }
        ((InmemoryCache) cache).buildIndex();

        return cache;
    }

    private static String getHash(BinRange range) {
        return range.start;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Result.BinRange> binRanges = new ArrayList<>();
                String start = "420000000000";
                String end = "429999999999";
                String cardType = "visa";
                binRanges.add(new Result.BinRange(start, end, cardType));
         start = "500000000000";
         end = "599999999999";
         cardType = "mc";
        binRanges.add(new Result.BinRange(start, end, cardType));

            Result.CardTypeCache cache = Result.buildCache(binRanges);
            if (cache != null) {
                System.out.println(String.valueOf(cache.get("5199999999991234")));
            }
    }
}
