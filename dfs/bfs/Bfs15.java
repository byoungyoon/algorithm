package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5014

public class Bfs15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Bfs15 test = new Bfs15();

        int answer = test.solution(F, S, G, U, D);
        System.out.println(answer == -1 ? "use the stairs" : answer);
    }

    private int solution(int F, int S, int G, int U, int D) {
        boolean[] visited = new boolean[F + 1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { S, 0 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == G)
                return curr[1];

            if (curr[0] < 1 || curr[0] > F || visited[curr[0]])
                continue;
            visited[curr[0]] = true;

            q.add(new int[] { curr[0] + U, curr[1] + 1 });
            q.add(new int[] { curr[0] - D, curr[1] + 1 });
        }

        return -1;
    }
}
