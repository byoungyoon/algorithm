package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7562

public class Bfs10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Bfs10 test = new Bfs10();
        StringTokenizer st;
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            System.out.println(test.solution(N, start, end));
        }

    }

    static int[][] direction = { { 2, 1 }, { 1, 2 }, { -2, 1 }, { -1, 2 }, { 2, -1 }, { 1, -2 }, { -2, -1 },
            { -1, -2 } };

    private int solution(int N, int[] start, int[] end) {
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start[0], start[1], 0 });

        int answer = (int) 2e9;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == end[0] && curr[1] == end[1]) {
                answer = Math.min(answer, curr[2]);
                continue;
            }

            for (int i = 0; i < direction.length; i++) {
                int nY = curr[0] + direction[i][0];
                int nX = curr[1] + direction[i][1];

                if (nY < 0 || nX < 0 || nY >= visited.length || nX >= visited[0].length || visited[nY][nX])
                    continue;

                visited[nY][nX] = true;
                q.add(new int[] { nY, nX, curr[2] + 1 });
            }
        }

        return answer;
    }
}
