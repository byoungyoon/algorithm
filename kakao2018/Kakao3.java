package kakao2018;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

// https://school.programmers.co.kr/learn/courses/30/lessons/17677

public class Kakao3 {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french^";

        Kakao3 test = new Kakao3();
        System.out.println(test.solution(str1, str2));
    }

    static final int VALUE = 65536;

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> hm = new HashMap<>();
        String pattern = "^[a-z]*$";

        int count2 = 0;
        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);
            if (!Pattern.matches(pattern, str))
                continue;
            count2++;
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        int count1 = 0;
        int min = 0;
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);
            if (!Pattern.matches(pattern, str))
                continue;
            count1++;

            if (!hm.containsKey(str))
                continue;

            if (hm.get(str) > 0) {
                hm.put(str, hm.get(str) - 1);
                min++;
            }
        }

        int max = count1 + count2 - min;
        if (count1 == 0 && count2 == 0)
            return VALUE;

        return (int) ((double) min / max * VALUE);
    }
}
