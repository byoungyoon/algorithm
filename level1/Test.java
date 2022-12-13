package level1;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086

public class Test {
    public static void main(String[] args) {
        String s = "foobar";

        Test test = new Test();
        System.out.println(Arrays.toString(test.solution(s)));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] index = new int[26 + 1];
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 96;
            if (index[value] == 0) {
                answer[i] = -1;
            } else {
                answer[i] = (i + 1) - index[value];
            }
            index[value] = i + 1;
        }

        return answer;
    }

}
