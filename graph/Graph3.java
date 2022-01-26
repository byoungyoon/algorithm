package graph;

import java.util.Arrays;

public class Graph3 {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

        Graph3 graph = new Graph3();
        System.out.println(graph.solution(n, edge));
    }

    private int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n];
        int[] route = new int[n];
        Arrays.fill(route, INF);

        route[0] = 0;
        visited[0] = true;
        int start = 1;

        for (int i = 0; i < n; i++) {
            dijkstra(edge, route, start);
            start = minK(route, visited);
        }

        Arrays.sort(route);

        int max = route[route.length - 1];
        int answer = 1;
        for (int i = route.length - 2; i >= 0; i--) {
            if (max != route[i])
                break;
            answer++;
        }

        return answer;
    }

    private void dijkstra(int[][] edge, int[] route, int start) {
        for (int i = 0; i < edge.length; i++) {
            if (edge[i][0] == start) {
                if (route[edge[i][1] - 1] > 1 + route[edge[i][0] - 1]) {
                    route[edge[i][1] - 1] = 1 + route[edge[i][0] - 1];
                }
            } else if (edge[i][1] == start) {
                if (route[edge[i][0] - 1] > 1 + route[edge[i][1] - 1]) {
                    route[edge[i][0] - 1] = 1 + route[edge[i][1] - 1];
                }
            }
        }
    }

    private int minK(int[] route, boolean[] visited) {
        int index = 0;
        int num = INF;

        for (int i = 0; i < route.length; i++) {
            if (visited[i])
                continue;

            if (route[i] < num) {
                num = route[i];
                index = i;
            }
        }

        visited[index] = true;
        return index + 1;
    }

}
