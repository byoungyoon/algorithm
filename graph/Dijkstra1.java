package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1753

public class Dijkstra1 {
    static Queue<Node> q = new PriorityQueue<>();
    static int INF = (int) 2e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(br.readLine());

        int[][] direction = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dijkstra1 test = new Dijkstra1();
        int[] answer = test.solution(direction, N, V);

        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(answer[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private int[] solution(int[][] direction, int N, int V) {
        Map<Integer, Queue<Node>> hm = new HashMap<>();
        for (int i = 0; i < direction.length; i++) {
            hm.computeIfAbsent(direction[i][0], data -> new LinkedList<>())
                    .add(new Node(direction[i][1], direction[i][2]));
        }

        int[] arr = new int[N + 1];
        Arrays.fill(arr, INF);

        arr[V] = 0;
        q.add(new Node(V, 0));

        while (!q.isEmpty()) {
            Node start = q.poll();

            if (!hm.containsKey(start.index) || arr[start.index] < start.value)
                continue;

            Queue<Node> qq = hm.get(start.index);
            while (!qq.isEmpty()) {
                Node end = qq.poll();
                if (start.value + end.value < arr[end.index]) {
                    arr[end.index] = start.value + end.value;
                    q.add(new Node(end.index, arr[end.index]));
                }
            }
        }

        return arr;
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
