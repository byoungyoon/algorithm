package kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/17684

public class Kakao5 {
    public static void main(String[] args) {
        String msg = "KAKAO";

        Kakao5 test = new Kakao5();
        System.out.println(Arrays.toString(test.solution(msg)));
    }

    String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z" };

    public int[] solution(String msg) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < alpha.length; i++) {
            hm.put(alpha[i], i + 1);
        }

        int sI = 0;
        int eI = 1;

        List<Integer> result = new ArrayList<>();
        int num = 0;
        while (eI <= msg.length()) {
            String str = msg.substring(sI, eI);

            if (hm.containsKey(str)) {
                eI++;
                num = hm.get(str);
            } else {
                hm.put(str, hm.size() + 1);
                result.add(num);
                sI = eI - 1;
                eI = sI + 1;
            }
        }
        result.add(hm.get(msg.substring(sI)));

        return result.stream().mapToInt(i -> i).toArray();
    }
}
