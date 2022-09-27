package kakao2018;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/17681

public class Kakao2 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = { 46, 33, 33, 22, 31, 50 };
        int[] arr2 = { 27, 56, 19, 14, 14, 10 };

        Kakao2 test = new Kakao2();
        System.out.println(Arrays.toString(test.solution(n, arr1, arr2)));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        StringBuilder sb;
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i] | arr2[i];
            sb = new StringBuilder();

            while (num != 0) {
                sb.insert(0, num % 2 == 0 ? " " : "#");
                num /= 2;
            }

            for (int j = sb.length(); j < n; j++) {
                sb.insert(0, " ");
            }

            answer[i] = sb.toString();
        }

        return answer;
    }
}
