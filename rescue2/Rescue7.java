package rescue2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// https://school.programmers.co.kr/learn/courses/30/lessons/118670

public class Rescue7 {
    public static void main(String[] args) {
        // int[][] rc = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // String[] operations = { "Rotate", "ShiftRow" };

        int[][] rc = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        String[] operations = { "ShiftRow", "Rotate", "ShiftRow", "Rotate" };

        Rescue7 test = new Rescue7();
        int[][] answer = test.solution(rc, operations);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }

    Deque<Deque<Integer>> rows;
    Deque<Integer> left;
    Deque<Integer> right;

    public int[][] solution(int[][] rc, String[] operations) {
        rows = new LinkedList<>();
        left = new LinkedList<>();
        right = new LinkedList<>();

        for (int i = 0; i < rc.length; i++) {
            left.offer(rc[i][0]);
            right.offer(rc[i][rc[0].length - 1]);

            Deque<Integer> deque = new LinkedList<>();
            for (int j = 1; j < rc[0].length - 1; j++) {
                deque.offer(rc[i][j]);
            }
            rows.offer(deque);
        }

        for (String operation : operations) {
            if (operation.equals("Rotate")) {
                rotate();
            } else {
                shiftRow();
            }
        }

        int[][] answer = new int[rc.length][rc[0].length];

        int index = 0;
        while (!rows.isEmpty()) {
            answer[index][0] = left.pollFirst();
            answer[index][answer[0].length - 1] = right.pollFirst();

            Deque<Integer> row = rows.pollFirst();
            int subIndex = 1;
            while (!row.isEmpty()) {
                answer[index][subIndex] = row.pollFirst();
                subIndex++;
            }

            index++;
        }

        return answer;
    }

    public void rotate() {
        Deque<Integer> first = rows.pollFirst();
        Deque<Integer> last = rows.pollLast();

        first.offerFirst(left.pollFirst());
        right.offerFirst(first.pollLast());
        last.offerLast(right.pollLast());
        left.offerLast(last.pollFirst());

        rows.offerFirst(first);
        rows.offerLast(last);
    }

    public void shiftRow() {
        left.offerFirst(left.pollLast());
        right.offerFirst(right.pollLast());

        rows.offerFirst(rows.pollLast());
    }
}
