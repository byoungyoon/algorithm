package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1261

public class Bfs13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Bfs13 test = new Bfs13();
        System.out.println(test.solution(map));
    }

    static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int INF = (int) 2e9;

    private int solution(int[][] map) {
        int[][] visited = new int[map.length][map[0].length];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], INF);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });
        visited[0][0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < direction.length; i++) {
                int nY = curr[0] + direction[i][0];
                int nX = curr[1] + direction[i][1];
                if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length)
                    continue;

                int nValue = curr[2] + map[nY][nX];
                if (visited[nY][nX] <= nValue)
                    continue;

                visited[nY][nX] = nValue;
                q.add(new int[] { nY, nX, nValue });
            }
        }

        return visited[map.length - 1][map[0].length - 1];
    }
}
