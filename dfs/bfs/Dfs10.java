package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/2667

public class Dfs10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Dfs10 test = new Dfs10();
        List<Integer> answer = test.solution(map);

        System.out.println(answer.size());
        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private List<Integer> solution(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 || visited[i][j])
                    continue;
                visited[i][j] = true;
                result.add(dfs(map, visited, i, j, 1));
            }
        }

        Collections.sort(result);
        return result;
    }

    private int dfs(int[][] map, boolean[][] visited, int y, int x, int count) {
        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || map[nY][nX] == 0 || visited[nY][nX])
                continue;

            visited[nY][nX] = true;
            count = dfs(map, visited, nY, nX, count + 1);
        }

        return count;
    }
}
