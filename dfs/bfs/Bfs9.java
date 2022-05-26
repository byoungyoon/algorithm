package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7569

public class Bfs9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][M][N];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < N; z++) {
                    map[i][j][z] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Bfs9 test = new Bfs9();
        System.out.println(test.solution(map));
    }

    static int[][] direction = { { 1, 0, 0 }, { 0, 1, 0 }, { -1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

    private int solution(int[][][] map) {
        boolean[][][] visited = new boolean[map.length][map[0].length][map[0][0].length];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                for (int z = 0; z < visited[0][0].length; z++) {
                    if (map[i][j][z] == 1)
                        q.add(new int[] { i, j, z, 0 });
                }
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < direction.length; i++) {
                int nZ = curr[0] + direction[i][0];
                int nY = curr[1] + direction[i][1];
                int nX = curr[2] + direction[i][2];

                if (nZ < 0 || nY < 0 || nX < 0 || nZ >= map.length || nY >= map[0].length || nX >= map[0][0].length
                        || visited[nZ][nY][nX] || map[nZ][nY][nX] != 0)
                    continue;
                visited[nZ][nY][nX] = true;
                q.add(new int[] { nZ, nY, nX, curr[3] + 1 });

                answer = Math.max(answer, curr[3] + 1);
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                for (int z = 0; z < visited[0][0].length; z++) {
                    if (map[i][j][z] == 0 && !visited[i][j][z])
                        return -1;
                }
            }
        }

        return answer;
    }
}
