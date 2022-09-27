package kakao2018;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/17680

public class Kakao1 {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = { "Jeju", "Jeju", "Jeju", "Jeju", "Jeju" };

        Kakao1 test = new Kakao1();
        System.out.println(test.solution(cacheSize, cities));
    }

    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;
    static final int INF = (int) 2e9;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * CACHE_MISS;

        Map<String, Integer> hm = new HashMap<>();

        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            String value = cities[i].toLowerCase();

            if (hm.size() >= cacheSize) {
                if (hm.containsKey(value)) {
                    hm.put(value, i);
                    answer += CACHE_HIT;
                } else {
                    int min = INF;
                    String temp = "";
                    for (String s : hm.keySet()) {
                        if (hm.get(s) < min) {
                            min = hm.get(s);
                            temp = s;
                        }
                    }

                    hm.remove(temp);
                    hm.put(value, i);
                    answer += CACHE_MISS;
                }
            } else {
                int count = hm.size();
                hm.put(value, i);

                if (count == hm.size()) {
                    answer += CACHE_HIT;
                } else {
                    answer += CACHE_MISS;
                }
            }
        }

        return answer;
    }
}
