package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2468

public class Dfs14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dfs14 test = new Dfs14();
        System.out.println(test.solution(map, N));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int solution(int[][] map, int N) {
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                hs.add(map[i][j]);
            }
        }

        boolean[][] visited;
        int answer = 1;
        for (Integer i : hs) {
            int count = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < map.length; j++) {
                for (int z = 0; z < map[0].length; z++) {
                    if (visited[j][z] || map[j][z] <= i)
                        continue;
                    dfs(map, visited, i, j, z);
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private void dfs(int[][] map, boolean[][] visited, int height, int y, int x) {
        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || visited[nY][nX] || map[nY][nX] <= height)
                continue;

            visited[nY][nX] = true;
            dfs(map, visited, height, nY, nX);
        }
    }
}
