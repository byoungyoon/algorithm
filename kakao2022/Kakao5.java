package kakao2022;

import java.util.Deque;
import java.util.LinkedList;

// https://school.programmers.co.kr/learn/courses/30/lessons/118670

public class Kakao5 {
    public static void main(String[] args) {
        int[][] rc = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
        String[] operations = { "Rotate" };

        Kakao5 test = new Kakao5();
        System.out.println(test.solution(rc, operations));
    }

    Deque<Integer> left;
    Deque<Deque<Integer>> center;
    Deque<Integer> right;

    public int[][] solution(int[][] rc, String[] operations) {
        left = new LinkedList<>();
        center = new LinkedList<>();
        right = new LinkedList<>();

        Deque<Integer> dq;
        for (int i = 0; i < rc.length; i++) {
            dq = new LinkedList<>();

            for (int j = 0; j < rc[0].length; j++) {
                if (j == 0)
                    left.offerLast(rc[i][j]);
                else if (j == rc[0].length - 1)
                    right.offerLast(rc[i][j]);
                else
                    dq.offerLast(rc[i][j]);
            }

            center.offerLast(dq);
        }

        for (String operation : operations) {
            if (operation.equals("Rotate"))
                onRotate();
            else
                onShiftRow();
        }

        dq = new LinkedList<>();
        int[][] answer = new int[rc.length][rc[0].length];

        for (int i = 0; i < answer.length; i++) {
            dq = center.pollFirst();

            for (int j = 0; j < answer[0].length; j++) {
                if (j == 0)
                    answer[i][j] = left.pollFirst();
                else if (j == answer[0].length - 1)
                    answer[i][j] = right.pollFirst();
                else
                    answer[i][j] = dq.pollFirst();
            }
        }

        return answer;
    }

    public void onRotate() {
        Deque<Integer> top = center.pollFirst();
        Deque<Integer> bottom = center.pollLast();

        top.offerFirst(left.pollFirst());
        right.offerFirst(top.pollLast());
        bottom.offerLast(right.pollLast());
        left.offerLast(bottom.pollFirst());

        center.offerFirst(top);
        center.offerLast(bottom);
    }

    public void onShiftRow() {
        left.offerFirst(left.pollLast());
        center.offerFirst(center.pollLast());
        right.offerFirst(right.pollLast());
    }
}
