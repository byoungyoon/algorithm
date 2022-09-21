package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/49189

public class Dijkstra7 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

        Dijkstra7 test = new Dijkstra7();
        System.out.println(test.solution(n, edge));
    }

    static final int INF = (int) 2e9;

    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < edge.length; i++) {
            hm.computeIfAbsent(edge[i][0], data -> new ArrayList<>()).add(edge[i][1]);
            hm.computeIfAbsent(edge[i][1], data -> new ArrayList<>()).add(edge[i][0]);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);

        Queue<Node> pq = new PriorityQueue<>();

        dp[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (int i : hm.get(node.index)) {
                if (dp[i] > node.value + 1) {
                    dp[i] = node.value + 1;
                    pq.offer(new Node(i, node.value + 1));
                }
            }
        }

        int answer = 0;
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (max < dp[i]) {
                answer = 1;
                max = dp[i];
            } else if (max == dp[i])
                answer++;
        }

        return answer;
    }

    class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return o.value - this.value;
        }
    }
}
