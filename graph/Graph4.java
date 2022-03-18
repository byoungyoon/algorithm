package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/81304

public class Graph4 {
    public static void main(String[] args) {
        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } };
        int[] traps = { 2, 3 };

        Graph4 graph = new Graph4();
        System.out.println(graph.solution(n, start, end, roads, traps));
    }

    static int INF = Integer.MAX_VALUE;
    static int answer = Integer.MAX_VALUE;

    public class Edge implements Comparable<Edge> {
        int to;
        int weight;
        int status;

        public Edge(int to, int weight, int status) {
            this.to = to;
            this.weight = weight;
            this.status = status;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "현재 노트 번호 : " + this.to + ", 가중치 : " + this.weight + ", 상태 : " + status;
        }
    }

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        List<Edge>[] adj = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            adj[road[0]].add(new Edge(road[1], road[2], 0));
            adj[road[1]].add(new Edge(road[0], road[2], 1));
        }

        Map<Integer, Integer> trap = new HashMap<>();
        for (int i = 0; i < traps.length; i++)
            trap.put(traps[i], i);

        // 다익스트라
        int[][] dist = new int[n + 1][1 << 10];
        for (int i = 1; i < n + 1; i++)
            Arrays.fill(dist[i], INF);

        Queue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start, 0, 0));
        dist[start][0] = 0;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            int curNode = edge.to;
            int curWeight = edge.weight;
            int curState = edge.status;

            if (curNode == end) {
                answer = answer < curWeight ? answer : curWeight;
                continue;
            }

            if (curWeight > dist[curNode][curState])
                continue;

            for (Edge next : adj[curNode]) {
                int nextNode = next.to;
                int nextWeight = next.weight;
                int isReverse = next.status;

                if (isReverse != (isConnected(curNode, nextNode, curState, trap) ? 1 : 0))
                    continue;

                int nextState = getNextState(curState, nextNode, trap);
                nextWeight += curWeight;

                if (nextWeight >= dist[nextNode][nextState])
                    continue;

                dist[nextNode][nextState] = nextWeight;
                q.add(new Edge(nextNode, nextWeight, nextState));
            }
        }

        return answer;
    }

    private int getNextState(int curState, int nextNode, Map<Integer, Integer> trap) {
        if (trap.containsKey(nextNode))
            curState ^= (1 << trap.get(nextNode));
        return curState;
    }

    private boolean isConnected(int curNode, int nextNode, int curState, Map<Integer, Integer> trap) {
        boolean currNodeTrapCk = false, nextNodeTrapCk = false;

        if (trap.containsKey(curNode))
            currNodeTrapCk = ((curState & (1 << trap.get(curNode))) != 0);

        if (trap.containsKey(nextNode))
            nextNodeTrapCk = ((curState & (1 << trap.get(nextNode))) != 0);

        return currNodeTrapCk ^ nextNodeTrapCk;
    }
}
