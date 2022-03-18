package heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42626

public class Heap3 {
    public static void main(String[] args) {
        int[] scoville = { 1, 2, 3, 9, 10, 12 };
        int K = 7;

        Heap3 heap = new Heap3();
        System.out.println(heap.solution(scoville, K));
    }

    static Queue<Integer> q = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        for (int i : scoville) {
            q.add(i);
        }

        int answer = 0;
        while (q.peek() < K) {
            if (q.size() < 2)
                return -1;

            q.add(q.poll() + (q.poll() * 2));
            answer++;
        }

        return answer;
    }
}
