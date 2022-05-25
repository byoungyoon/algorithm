package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7576

public class Bfs7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Bfs7 test = new Bfs7();
        System.out.println(test.bfs(map));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visted = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[] { i, j, 0 });
                    visted[i][j] = true;
                }
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int[] index = q.poll();

            for (int i = 0; i < direction.length; i++) {
                int nY = index[0] + direction[i][0];
                int nX = index[1] + direction[i][1];

                if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || map[nY][nX] == -1 || visted[nY][nX])
                    continue;
                visted[nY][nX] = true;

                q.add(new int[] { nY, nX, index[2] + 1 });
                count = Math.max(count, index[2] + 1);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 && !visted[i][j]) {
                    return -1;
                }
            }
        }

        return count;
    }
}
