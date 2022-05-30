package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2252

public class Topology1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Topology1 test = new Topology1();
        System.out.println(test.solution(arr, N));
    }

    private String solution(int[][] arr, int N) {
        Map<Integer, List<Integer>> hm = new HashMap<>();

        int[] count = new int[N + 1];
        for (int i = 0; i < arr.length; i++) {
            hm.computeIfAbsent(arr[i][0], data -> new LinkedList<>()).add(arr[i][1]);
            count[arr[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0)
                q.add(i);

        }

        StringBuilder answer = new StringBuilder("");
        while (!q.isEmpty()) {
            int curr = q.poll();
            answer.append(curr + " ");

            if (hm.containsKey(curr)) {
                for (int i : hm.get(curr)) {
                    count[i]--;

                    if (count[i] == 0) {
                        q.add(i);
                    }
                }
            }

        }

        return answer.toString();
    }
}
