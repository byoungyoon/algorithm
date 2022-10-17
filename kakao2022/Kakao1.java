package kakao2022;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666

public class Kakao1 {
    public static void main(String[] args) {
        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };

        Kakao1 test = new Kakao1();
        System.out.println(test.solution(survey, choices));
    }

    public String solution(String[] survey, int[] choices) {
        char[] sur = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };

        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < sur.length; i++) {
            hm.put(sur[i], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char target = choices[i] - 4 < 0 ? survey[i].charAt(0) : survey[i].charAt(1);
            int value = Math.abs(choices[i] - 4);

            hm.put(target, hm.get(target) + value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sur.length; i += 2) {
            char target = hm.get(sur[i]) >= hm.get(sur[i + 1]) ? sur[i] : sur[i + 1];

            sb.append(target);
        }

        return sb.toString();
    }
}
