package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11725

public class Dfs17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] direction = new int[N - 1][2];
        StringTokenizer st;
        for (int i = 0; i < direction.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direction[i][0] = Integer.parseInt(st.nextToken());
            direction[i][1] = Integer.parseInt(st.nextToken());
        }

        Dfs17 test = new Dfs17();
        int[] result = test.solution(N, direction);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] answer;

    private int[] solution(int N, int[][] direction) {
        Map<Integer, Queue<Integer>> hm = new HashMap<>();
        for (int i = 0; i < direction.length; i++) {
            hm.computeIfAbsent(direction[i][0], data -> new LinkedList<>()).add(direction[i][1]);
            hm.computeIfAbsent(direction[i][1], data -> new LinkedList<>()).add(direction[i][0]);
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        answer = new int[N + 1];

        dfs(hm, visited, 1, 0);

        return Arrays.copyOfRange(answer, 2, answer.length);
    }

    private void dfs(Map<Integer, Queue<Integer>> hm, boolean[] visited, int curr, int pre) {
        answer[curr] = pre;

        if (hm.containsKey(curr)) {
            Queue<Integer> q = hm.get(curr);
            while (!q.isEmpty()) {
                int index = q.poll();
                if (visited[index])
                    continue;
                visited[index] = true;
                dfs(hm, visited, index, curr);
            }
        }
    }
}
