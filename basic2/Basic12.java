package basic2;

// https://programmers.co.kr/learn/courses/30/lessons/12940

import java.util.Arrays;

public class Basic12 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        Basic12 test = new Basic12();
        System.out.println(Arrays.toString(test.solution(n, m)));
    }

    public int[] solution(int n, int m) {
        int max = n;
        int min = m;
        if (n > m) {
            max = m;
            min = n;
        }

        while (true) {
            int remain = max % min;
            if (remain == 0)
                break;
            max = min;
            min = remain;
        }

        int[] answer = { min, (n / min) * (m / min) * min };
        return answer;
    }
}
