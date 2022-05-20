package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17070

public class Dp17 {
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

        Dp17 dp = new Dp17();
        System.out.println(dp.solution(N, map));
    }

    static int answer = 0;

    private int solution(int N, int[][] map) {
        dfs(map, 0, 1, 0);
        return answer;
    }

    private void dfs(int[][] map, int y, int x, int dir) {
        if (y < 0 || x < 0 || y >= map.length || x >= map[0].length)
            return;

        if (dir == 0 || dir == 1) {
            if (map[y][x] == 1)
                return;
        } else {
            if (map[y][x] == 1 || map[y - 1][x] == 1 || map[y][x - 1] == 1)
                return;
        }

        if (y == map.length - 1 && x == map[0].length - 1) {
            answer++;
            return;
        }

        if (dir == 0) {
            dfs(map, y, x + 1, 0);
            dfs(map, y + 1, x + 1, 2);
        } else if (dir == 1) {
            dfs(map, y + 1, x, 1);
            dfs(map, y + 1, x + 1, 2);
        } else {
            dfs(map, y, x + 1, 0);
            dfs(map, y + 1, x, 1);
            dfs(map, y + 1, x + 1, 2);
        }
    }
}
