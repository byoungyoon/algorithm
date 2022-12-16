import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> q = new PriorityQueue<>();

        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            if (q.size() >= k)
                q.offer(Math.max(q.poll(), score[i]));
            else
                q.offer(score[i]);

            answer[i] = q.peek();
        }

        return answer;
    }
}