package basic2;

import java.util.Arrays;
import java.util.Collections;

public class Basic4 {
    public static void main(String[] args) {
        int[] A = { 1, 4, 2 };
        int[] B = { 5, 4, 4 };

        Basic4 basic = new Basic4();
        System.out.println(basic.solution(A, B));
    }

    private int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Integer[] BB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(BB, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * BB[i];
        }

        return answer;
    }
}
