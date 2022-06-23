package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1167

public class Dfs20 {
    static Map<Integer, List<Node>> hm = new HashMap<>();

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int V = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int index = Integer.parseInt(st.nextToken());
                if (index == -1)
                    continue;

                int value = Integer.parseInt(st.nextToken());

                hm.computeIfAbsent(V, data -> new ArrayList<>()).add(new Node(index, value));
            }
        }

        Dfs20 test = new Dfs20();
        System.out.println(test.solution(N));
    }

    static int base = -1;
    static int max = -1;

    private int solution(int N) {
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0, visited);
        visited[1] = false;

        max = -1;
        visited[base] = true;
        dfs(base, 0, visited);

        return max;
    }

    private void dfs(int index, int value, boolean[] visited) {
        if (max < value) {
            max = value;
            base = index;
        }

        for (Node node : hm.get(index)) {
            int nextIndex = node.index;
            if (visited[nextIndex])
                continue;

            visited[nextIndex] = true;
            dfs(nextIndex, value + node.value, visited);
            visited[nextIndex] = false;
        }
    }
}
