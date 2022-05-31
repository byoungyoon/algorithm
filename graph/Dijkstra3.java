package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1238

public class Dijkstra3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[][] direction = new int[T][3];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dijkstra3 test = new Dijkstra3();
        System.out.println(test.solution(direction, N, end));
    }

    static int INF = (int) 1e9;

    private int solution(int[][] direction, int N, int end) {
        Map<Integer, Queue<Integer>> hm = new HashMap<>();
        Map<Integer, Queue<Integer>> hm2 = new HashMap<>();
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < direction.length; i++) {
            hm.computeIfAbsent(direction[i][0], data -> new LinkedList<>()).add(direction[i][1]);
            hm2.computeIfAbsent(direction[i][1], data -> new LinkedList<>()).add(direction[i][0]);
            map[direction[i][0]][direction[i][1]] = direction[i][2];
        }

        int[] node = new int[N + 1];
        int[] node2 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = end == i ? 0 : INF;
            node2[i] = end == i ? 0 : INF;
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(end, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (hm.containsKey(curr.index)) {
                Queue<Integer> qq = hm.get(curr.index);
                while (!qq.isEmpty()) {
                    int next = qq.poll();

                    if (map[curr.index][next] + node[curr.index] < node[next]) {
                        node[next] = map[curr.index][next] + node[curr.index];
                        q.add(new Node(next, node[next]));
                    }
                }
            }
        }

        q.add(new Node(end, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (hm2.containsKey(curr.index)) {
                Queue<Integer> qq = hm2.get(curr.index);
                while (!qq.isEmpty()) {
                    int next = qq.poll();

                    if (map[next][curr.index] + node2[curr.index] < node2[next]) {
                        node2[next] = map[next][curr.index] + node2[curr.index];
                        q.add(new Node(next, node2[next]));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, node[i] + node2[i]);
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
            return this.value - o.value;
        }
    }
}
