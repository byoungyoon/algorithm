package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42578

public class Hash22 {
    public static void main(String[] args) {
        String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" } };
        Hash22 test = new Hash22();
        System.out.println(test.solution(clothes));
    }

    public int solution(String[][] clothes) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String[] cloth : clothes) {
            hm.computeIfAbsent(cloth[1], data -> new ArrayList<>()).add(cloth[0]);
        }

        int answer = 1;
        for (String s : hm.keySet()) {
            answer *= hm.get(s).size() + 1;
        }

        return answer - 1;
    }
}
