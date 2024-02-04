package level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085

public class Test {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = { 4, 2, 4, 5, 3, 3, 1 };

        Test test = new Test();
        System.out.println(test.solution(n, k, enemy));
    }

    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);

        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] <= n) {
                n -= enemy[i];
                pq.offer(enemy[i]);
            } else {
                if (k == 0)
                    return i;

                k--;
                if (pq.peek() > enemy[i]) {
                    n += pq.poll() - enemy[i];
                    pq.offer(enemy[i]);
                }
            }
        }

        return enemy.length;
    }
}
