package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/4963

public class Dfs12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int[][] map;
        Dfs12 test = new Dfs12();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0)
                break;

            map = new int[M][N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(test.solution(map));
        }
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    private int solution(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;
                dfs(map, visited, i, j);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] map, boolean[][] visited, int y, int x) {
        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || map[nY][nX] == 0 || visited[nY][nX])
                continue;
            visited[nY][nX] = true;
            dfs(map, visited, nY, nX);
        }
    }
}
