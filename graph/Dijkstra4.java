package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1504

public class Dijkstra4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] direction = new int[T][3];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());

        Dijkstra4 test = new Dijkstra4();
        System.out.println(test.solution(direction, N, mid1, mid2));
    }

    static int INF = 10000000;
    Map<Integer, List<Node>> hm;

    private int solution(int[][] direction, int N, int mid1, int mid2) {
        hm = new HashMap<>();
        for (int i = 0; i < direction.length; i++) {
            hm.computeIfAbsent(direction[i][0], data -> new LinkedList<>())
                    .add(new Node(direction[i][1], direction[i][2]));
            hm.computeIfAbsent(direction[i][1], data -> new LinkedList<>())
                    .add(new Node(direction[i][0], direction[i][2]));
        }

        int[] sArr = dijkstra(new int[N + 1], 1);
        int[] m1Arr = dijkstra(new int[N + 1], mid1);
        int[] m2Arr = dijkstra(new int[N + 1], mid2);

        int case1 = sArr[mid1] + m1Arr[mid2] + m2Arr[N];
        int case2 = sArr[mid2] + m2Arr[mid1] + m1Arr[N];

        if (case1 >= INF && case2 >= INF)
            return -1;

        return Math.min(case1, case2);
    }

    private int[] dijkstra(int[] arr, int index) {
        Queue<Node> q = new PriorityQueue<>();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i == index ? 0 : INF;
        }

        q.add(new Node(index, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (hm.containsKey(curr.index)) {
                List<Node> list = hm.get(curr.index);
                for (Node next : list) {
                    if (arr[curr.index] + next.value < arr[next.index]) {
                        arr[next.index] = arr[curr.index] + next.value;
                        q.add(new Node(next.index, arr[next.index]));
                    }
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
