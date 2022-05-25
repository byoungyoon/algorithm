package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10026

public class Dfs13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] map = new String[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        Dfs13 test = new Dfs13();
        System.out.println(test.solution(map, N));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private String solution(String[][] map, int N) {
        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];

        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited1[i][j]) {
                    dfs(map, visited1, 0, map[i][j], i, j);
                    result1++;
                }
                if (!visited2[i][j]) {
                    dfs(map, visited2, 1, map[i][j], i, j);
                    result2++;
                }
            }
        }

        return result1 + " " + result2;
    }

    private void dfs(String[][] map, boolean[][] visited, int type, String color, int y, int x) {
        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || visited[nY][nX])
                continue;

            if (type == 0) {
                if (!map[nY][nX].equals(color))
                    continue;
            } else {
                if (color.equals("R") || color.equals("G")) {
                    if (map[nY][nX].equals("B"))
                        continue;
                } else {
                    if (!map[nY][nX].equals(color))
                        continue;
                }
            }

            visited[nY][nX] = true;
            dfs(map, visited, type, color, nY, nX);
        }
    }
}
