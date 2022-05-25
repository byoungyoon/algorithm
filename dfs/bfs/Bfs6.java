package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2606

public class Bfs6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[][] direction = new boolean[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            direction[start][end] = true;
            direction[end][start] = true;
        }

        Bfs6 test = new Bfs6();
        System.out.println(test.solution(direction, N));
    }

    private int solution(boolean[][] direction, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        int answer = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 1; i < direction.length; i++) {
                if (!direction[curr][i] || visited[i])
                    continue;
                visited[i] = true;

                q.add(i);
                answer++;
            }
        }

        return answer;
    }
}
