package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1012

public class Dfs11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map;
        Dfs11 test = new Dfs11();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            System.out.println(test.solution(map));
        }
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int solution(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        int answer = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (map[i][j] == 0 || visited[i][j])
                    continue;
                visited[i][j] = true;
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

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || visited[nY][nX] || map[nY][nX] == 0)
                continue;
            visited[nY][nX] = true;
            dfs(map, visited, nY, nX);
        }
    }
}
