package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16953

public class Bfs17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Bfs17 test = new Bfs17();
        System.out.println(test.solution(A, B));
    }

    public int solution(int A, int B) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { A, 1 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == B)
                return curr[1];

            long n1 = curr[0] * 2;
            long n2 = Long.parseLong(curr[0] + "1");

            if (n1 > B)
                continue;
            q.add(new int[] { Long.valueOf(n1).intValue(), curr[1] + 1 });

            if (n2 > B)
                continue;
            q.add(new int[] { Long.valueOf(n2).intValue(), curr[1] + 1 });
        }

        return -1;
    }
}
