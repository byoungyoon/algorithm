package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13549

public class Dfs18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dfs18 test = new Dfs18();
        System.out.println(test.solution(start, end));
    }

    static int INF = (int) 2e9;

    private int solution(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start, 0 });

        int[] arr = new int[100001];
        Arrays.fill(arr, INF);

        int answer = INF;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == end) {
                answer = Math.min(answer, curr[1]);
                continue;
            }

            int[] next = { curr[0] + 1, curr[0] - 1, curr[0] * 2 };
            for (int i = 0; i < next.length; i++) {
                int nextIndex = next[i];
                if (next[i] >= arr.length || next[i] < 0)
                    continue;

                if (i != 2) {
                    if (arr[nextIndex] > curr[1] + 1) {
                        arr[nextIndex] = curr[1] + 1;
                        q.add(new int[] { nextIndex, curr[1] + 1 });
                    }
                } else {
                    if (arr[nextIndex] > curr[1]) {
                        arr[nextIndex] = curr[1];
                        q.add(new int[] { nextIndex, curr[1] });
                    }
                }

            }
        }

        return answer;
    }
}
