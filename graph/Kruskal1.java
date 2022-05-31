package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1922

public class Kruskal1 {
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

        Kruskal1 test = new Kruskal1();
        System.out.println(test.solution(direction, N));
    }

    private int solution(int[][] direction, int N) {
        Queue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < direction.length; i++) {
            q.add(new Node(direction[i][0], direction[i][1], direction[i][2]));
        }

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int answer = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (find(parent, parent[node.left]) != find(parent, parent[node.right])) {
                union(parent, node.left, node.right);
                answer += node.value;
            }
        }

        return answer;
    }

    private void union(int[] parent, int left, int right) {
        int pLeft = find(parent, left);
        int pRight = find(parent, right);

        if (pLeft < pRight) {
            parent[pRight] = pLeft;
        } else {
            parent[pLeft] = pRight;
        }
    }

    private int find(int[] parent, int curr) {
        if (curr == parent[curr])
            return curr;
        return find(parent, parent[curr]);
    }

    class Node implements Comparable<Node> {
        int left;
        int right;
        int value;

        public Node(int left, int right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
