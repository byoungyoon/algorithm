package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14226

public class Bfs16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Bfs16 test = new Bfs16();
        System.out.println(test.solution(N));
    }

    static int INF = (int) 2e9;

    private int solution(int N) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 1, 0, 0 });

        boolean[][] visited = new boolean[2000][2000];

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == N) {
                return curr[2];
            }

            if (curr[0] < 0 || curr[0] >= visited.length || visited[curr[0]][curr[1]])
                continue;
            visited[curr[0]][curr[1]] = true;

            q.add(new int[] { curr[0] + curr[1], curr[1], curr[2] + 1 });
            q.add(new int[] { curr[0], curr[0], curr[2] + 1 });
            q.add(new int[] { curr[0] - 1, curr[1], curr[2] + 1 });
        }

        return -1;
    }
}
