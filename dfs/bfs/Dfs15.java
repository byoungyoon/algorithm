package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1987

public class Dfs15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] map = new String[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        Dfs15 test = new Dfs15();
        System.out.println(test.solution(map));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int answer = 0;

    private int solution(String[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        boolean[] en = new boolean[26];
        visited[0][0] = true;
        en[(int) map[0][0].charAt(0) - 65] = true;

        dfs(map, visited, en, 1, 0, 0);

        return answer;
    }

    private void dfs(String[][] map, boolean[][] visited, boolean[] en, int depth, int y, int x) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || visited[nY][nX])
                continue;
            int index = (int) map[nY][nX].charAt(0) - 65;
            if (en[index])
                continue;

            visited[nY][nX] = true;
            en[index] = true;
            dfs(map, visited, en, depth + 1, nY, nX);
            visited[nY][nX] = false;
            en[index] = false;
        }
    }
}
