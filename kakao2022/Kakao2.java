package kakao2022;

import java.util.Deque;
import java.util.LinkedList;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667

public class Kakao2 {
    public static void main(String[] args) {
        int[] queue1 = { 3, 2, 7, 2 };
        int[] queue2 = { 4, 6, 5, 1 };

        Kakao2 test = new Kakao2();
        System.out.println(test.solution(queue1, queue2));
    }

    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> dq1 = new LinkedList<>();
        Deque<Integer> dq2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            dq1.offerLast(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            dq2.offerLast(queue2[i]);
            sum2 += queue2[i];
        }

        int answer = 0;
        int limit = Math.max(queue1.length, queue2.length) * 3;
        while (sum1 != sum2) {
            if (dq1.isEmpty() || dq2.isEmpty() || answer > limit)
                return -1;

            int target;
            if (sum1 < sum2) {
                target = dq2.pollFirst();

                dq1.offerLast(target);
                sum1 += target;
                sum2 -= target;
            } else {
                target = dq1.pollFirst();

                dq2.offerLast(target);
                sum2 += target;
                sum1 -= target;
            }

            answer++;
        }

        return answer;
    }
}
