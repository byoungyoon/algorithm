package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2206

public class Bfs11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Bfs11 test = new Bfs11();
        System.out.println(test.solution(map));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int solution(int[][] map) {
        boolean[][][] visited = new boolean[map.length][map[0].length][2];
        Queue<int[]> q = new LinkedList<>();

        visited[0][0][0] = true;
        q.add(new int[] { 0, 0, 0, 1 });

        int answer = -1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == map.length - 1 && curr[1] == map[0].length - 1) {
                answer = curr[3];
                break;
            }

            for (int i = 0; i < direction.length; i++) {
                int nY = curr[0] + direction[i][0];
                int nX = curr[1] + direction[i][1];
                int hole = curr[2];

                if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || visited[nY][nX][hole])
                    continue;
                visited[nY][nX][hole] = true;

                if (hole == 0 && map[nY][nX] == 1) {
                    q.add(new int[] { nY, nX, 1, curr[3] + 1 });
                } else {
                    if (map[nY][nX] == 1)
                        continue;

                    q.add(new int[] { nY, nX, hole, curr[3] + 1 });
                }
            }
        }

        return answer;
    }
}
