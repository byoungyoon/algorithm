package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1260

public class Dfs9 {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[][] direction = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            direction[i][0] = Integer.parseInt(st.nextToken());
            direction[i][1] = Integer.parseInt(st.nextToken());
        }

        map = new boolean[N + 1][N + 1];
        for (int i = 0; i < direction.length; i++) {
            map[direction[i][0]][direction[i][1]] = true;
            map[direction[i][1]][direction[i][0]] = true;
        }

        Dfs9 test = new Dfs9();
        System.out.println(test.getDfs(N, V, direction));
        System.out.println(test.getBfs(N, V, direction));
    }

    static StringBuilder sb;

    private String getDfs(int N, int V, int[][] direction) {
        sb = new StringBuilder();

        boolean[] visited = new boolean[N + 1];
        visited[V] = true;

        sb.append(V + " ");
        dfs(N, visited, V);

        return sb.toString();
    }

    private void dfs(int N, boolean[] visited, int curr) {
        for (int i = 1; i <= N; i++) {
            if (!map[curr][i] || visited[i])
                continue;
            visited[i] = true;
            sb.append(i + " ");
            dfs(N, visited, i);
        }
    }

    private String getBfs(int N, int V, int[][] direction) {
        sb = new StringBuilder();

        Queue<Integer> qq = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        qq.add(V);
        visited[V] = true;

        sb.append(V + " ");

        while (!qq.isEmpty()) {
            int next = qq.poll();

            for (int i = 1; i <= N; i++) {
                if (!map[next][i] || visited[i])
                    continue;
                visited[i] = true;
                sb.append(i + " ");
                qq.add(i);
            }
        }

        return sb.toString();
    }
}
