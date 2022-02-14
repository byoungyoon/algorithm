package array;

import java.util.ArrayList;
import java.util.List;

public class Array20 {
    static final int CACHE_MISS = 5;
    static final int CACHE_HIT = 1;

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };

        Array20 test = new Array20();
        System.out.println(test.solution(cacheSize, cities));
    }

    private int solution(int cacheSize, String[] cities) {
        List<String> list = new ArrayList<>();

        int answer = 0;
        if (cacheSize == 0)
            return cities.length * CACHE_MISS;

        for (String city : cities) {
            city = city.toLowerCase();

            if (list.indexOf(city) != -1) {
                list.remove(city);
                list.add(city);
                answer += CACHE_HIT;
                continue;
            }

            if (list.size() < cacheSize) {
                list.add(city);
            } else {
                list.remove((int) 0);
                list.add(city);
            }
            answer += CACHE_MISS;
        }

        return answer;
    }
}
