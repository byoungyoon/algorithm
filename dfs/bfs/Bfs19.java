package dfs.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/67259

public class Bfs19 {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };

        Bfs19 test = new Bfs19();
        System.out.println(test.solution(board));
    }

    static final int INF = (int) 2e9;
    int[][] direction = { { 1, 0, 1 }, { 0, 1, 0 }, { -1, 0, 1 }, { 0, -1, 0 } };

    public int solution(int[][] board) {
        int[][][] map = new int[board.length][board[0].length][2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                Arrays.fill(map[i][j], INF);
            }
        }

        Queue<Node> q = new LinkedList<>();
        if (board[0][1] == 0)
            q.add(new Node(0, 1, 0, 100));
        if (board[1][0] == 0)
            q.add(new Node(1, 0, 1, 100));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < direction.length; i++) {
                int nextY = node.y + direction[i][0];
                int nextX = node.x + direction[i][1];
                int nextInc = direction[i][2];

                if (nextY < 0 || nextX < 0 || nextY >= board.length || nextX >= board[0].length
                        || board[nextY][nextX] == 1)
                    continue;

                int value = node.inc != nextInc ? 600 : 100;

                if (map[nextY][nextX][nextInc] == 0 || map[nextY][nextX][nextInc] > node.value + value) {
                    map[nextY][nextX][nextInc] = node.value + value;
                    q.add(new Node(nextY, nextX, nextInc, node.value + value));
                }
            }
        }

        return Math.min(map[board.length - 1][board[0].length - 1][0], map[board.length - 1][board[0].length - 1][1]);
    }

    class Node {
        int y;
        int x;
        int inc;
        int value;

        public Node(int y, int x, int inc, int value) {
            this.y = y;
            this.x = x;
            this.inc = inc;
            this.value = value;
        }
    }
}
