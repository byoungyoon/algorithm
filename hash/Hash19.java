package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Hash19 {
    public static void main(String[] args) {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

        Hash19 hash = new Hash19();
        System.out.println(hash.solution(fees, records));
    }

    private List<Integer> solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<>();
        Map<Integer, Integer> price = new TreeMap<>();

        for (String record : records) {
            String[] value = record.split(" ");

            switch (value[2]) {
                case "IN":
                    parking.put(value[1], time(value[0]));
                    break;
                case "OUT":
                    price.put(Integer.parseInt(value[1]), price.getOrDefault(Integer.parseInt(value[1]), 0)
                            + (time(value[0]) - parking.get(value[1])));
                    parking.remove(value[1]);
                    break;
            }
        }

        int maxTime = time("23:59");
        for (String s : parking.keySet()) {
            price.put(Integer.parseInt(s), price.getOrDefault(Integer.parseInt(s), 0) + maxTime - parking.get(s));
        }

        List<Integer> answer = new ArrayList<>();
        for (Integer i : price.keySet()) {
            answer.add(priceCk(price.get(i), fees[1], fees[0], fees[3], fees[2]));
        }

        return answer;
    }

    private int time(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }

    private int priceCk(int n, int defaultPrice, int defaultTime, int addPrice, int addTime) {
        n = n - defaultTime;
        if (n < 0)
            return defaultPrice;

        int price = n / addTime * addPrice;
        if (n % addTime != 0)
            price += addPrice;

        return defaultPrice + price;
    }
}
