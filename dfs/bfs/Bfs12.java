package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13460

public class Bfs12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] map = new String[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j];
            }
        }

        Bfs12 test = new Bfs12();
        System.out.println(test.solution(map));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int solution(String[][] map) {
        Marble marble = new Marble();

        int[] end = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("R")) {
                    marble.rY = i;
                    marble.rX = j;
                } else if (map[i][j].equals("B")) {
                    marble.bY = i;
                    marble.bX = j;
                } else if (map[i][j].equals("O")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        boolean[][][][] visited = new boolean[map.length][map[0].length][map.length][map[0].length];
        visited[marble.rY][marble.rX][marble.bY][marble.bX] = true;

        Queue<Marble> q = new LinkedList<>();
        q.add(marble);

        while (!q.isEmpty()) {
            Marble curr = q.poll();

            for (int i = 0; i < direction.length; i++) {
                Marble next = new Marble();
                int count = curr.count + 1;

                if (count > 10)
                    return -1;

                for (int j = 1; j <= 10; j++) {
                    if (next.onRed() && next.onBlue())
                        break;

                    if (!next.onRed()) {
                        int nRY = curr.rY + direction[i][0] * j;
                        int nRX = curr.rX + direction[i][1] * j;

                        if (map[nRY][nRX].equals("#")) {
                            next.rY = nRY - direction[i][0];
                            next.rX = nRX - direction[i][1];
                        } else if (map[nRY][nRX].equals("O")) {
                            next.rY = nRY;
                            next.rX = nRX;
                        }
                    }

                    if (!next.onBlue()) {
                        int nBY = curr.bY + direction[i][0] * j;
                        int nBX = curr.bX + direction[i][1] * j;

                        if (map[nBY][nBX].equals("#")) {
                            next.bY = nBY - direction[i][0];
                            next.bX = nBX - direction[i][1];
                        } else if (map[nBY][nBX].equals("O")) {
                            next.bY = nBY;
                            next.bX = nBX;
                        }
                    }
                }

                if ((next.rY == end[0] && next.rX == end[1]) || (next.bY == end[0] && next.bX == end[1])) {
                    if (next.rY == next.bY && next.rX == next.bX || next.bY == end[0] && next.bX == end[1])
                        continue;

                    return count;
                }

                if (next.rY == next.bY && next.rX == next.bX) {
                    switch (i) {
                        case 0:
                            if (curr.rY > curr.bY) {
                                next.bY--;
                            } else {
                                next.rY--;
                            }

                            break;
                        case 2:
                            if (curr.rY > curr.bY) {
                                next.rY++;
                            } else {
                                next.bY++;
                            }

                            break;
                        case 1:
                            if (curr.rX > curr.bX) {
                                next.bX--;
                            } else {
                                next.rX--;
                            }

                            break;
                        case 3:
                            if (curr.rX > curr.bX) {
                                next.rX++;
                            } else {
                                next.bX++;
                            }

                            break;
                        default:
                            break;
                    }
                }

                if (visited[next.rY][next.rX][next.bY][next.bX])
                    continue;
                visited[next.rY][next.rX][next.bY][next.bX] = true;

                next.count = count;
                q.add(next);
            }
        }

        return -1;
    }

    class Marble {
        int rY;
        int rX;
        int bY;
        int bX;
        int count;

        public Marble() {
            this.rY = -1;
            this.rX = -1;
            this.bY = -1;
            this.bX = -1;
            this.count = 0;
        }

        public boolean onRed() {
            return this.rY != -1 && this.rX != -1;
        }

        public boolean onBlue() {
            return this.bY != -1 && this.bX != -1;
        }
    }
}
