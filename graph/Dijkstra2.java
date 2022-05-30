package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1916

public class Dijkstra2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        int[][] direction = new int[T][3];
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra2 test = new Dijkstra2();
        System.out.println(test.solution(direction, N, start, end));
    }

    static int INF = (int) 1e9;

    private int solution(int[][] direction, int N, int start, int end) {
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < direction.length; i++) {
            map[direction[i][0]][direction[i][1]] = Math.min(direction[i][2], map[direction[i][0]][direction[i][1]]);
        }

        int[] node = new int[N + 1];
        for (int i = 1; i < node.length; i++) {
            node[i] = i == start ? 0 : INF;
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[curr.index][i] == INF)
                    continue;

                if (map[curr.index][i] + curr.value < node[i]) {
                    node[i] = map[curr.index][i] + curr.value;
                    q.add(new Node(i, node[i]));
                }
            }
        }

        return node[end];
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
