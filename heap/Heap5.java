package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42628

public class Heap5 {
    public static void main(String[] args) {
        String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };

        Heap5 heap = new Heap5();
        System.out.println(Arrays.toString(heap.solution(operations)));
    }

    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();

        for (String operation : operations) {
            int value = Integer.parseInt(operation.split(" ")[1]);
            if (operation.startsWith("I")) {
                maxQ.add(value);
                minQ.add(value);
            } else {
                if (maxQ.isEmpty() || minQ.isEmpty())
                    continue;

                int num = value == 1 ? maxQ.peek() : minQ.peek();
                maxQ.remove(num);
                minQ.remove(num);
            }
        }

        int[] answer = { 0, 0 };
        if (maxQ.isEmpty() || minQ.isEmpty())
            return answer;

        answer[0] = maxQ.poll();
        answer[1] = minQ.poll();

        return answer;
    }
}
