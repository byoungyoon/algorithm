package rescue2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129

public class Rescue8 {
    public static void main(String[] args) {
        String s = "110010101001";

        Rescue8 test = new Rescue8();
        System.out.println(Arrays.toString(test.solution(s)));
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        int len = 0;
        while (!s.equals("1")) {
            len = s.length();
            answer[0]++;

            s = s.replaceAll("0", "");
            answer[1] += len - s.length();

            s = binary(s);
        }

        return answer;
    }

    public String binary(String s) {
        int temp = s.length();

        StringBuilder sb = new StringBuilder();
        while (!(temp == 0)) {
            sb.insert(0, temp % 2);
            temp /= 2;
        }

        return sb.toString();
    }
}
