package rescue2;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12987

public class Rescue10 {
    public static void main(String[] args) {
        int[] A = { 5, 1, 3, 7 };
        int[] B = { 2, 2, 6, 8 };

        Rescue10 test = new Rescue10();
        System.out.println(test.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int cA = 0;
        int cB = 0;

        while (cB != B.length) {
            if (A[cA] < B[cB]) {
                cA++;
                cB++;
                answer++;
            } else {
                cB++;
            }
        }

        return answer;
    }
}
