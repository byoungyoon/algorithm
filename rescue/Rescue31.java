package rescue;

import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/84512

public class Rescue31 {
    public static void main(String[] args) {
        String word = "UUUUU";

        Rescue31 rescue = new Rescue31();
        System.out.println(rescue.solution(word));
    }

    static List<String> en = Arrays.asList(new String[] { "A", "E", "I", "O", "U" });

    public int solution(String word) {
        int answer = 1;

        String temp = "A";
        while (!word.equals(temp)) {
            temp = nextStr(temp, false);
            answer++;
        }

        return answer;
    }

    public String nextStr(String str, boolean type) {
        // 전체의 길이가 5가 아닐 경우 5가 될 때까지 A 플러스
        // 전체가 5일때 끝 자리 U일경우 그 자리 사라지고 올림
        // 전체가 5이고 끝 자리가 U가 아닐 경우 그 자리 다음 문자
        int len = str.length();

        if (!type && len != 5) {
            return str += "A";
        }

        if (str.endsWith("U")) {
            str = nextStr(str.substring(0, len - 1), true);
        } else {
            str = str.substring(0, len - 1) + en.get(en.indexOf(str.charAt(len - 1) + "") + 1);
        }

        return str;
    }
}
