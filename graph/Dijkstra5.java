package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/118669/solution_groups?language=java&type=my

public class Dijkstra5 {
    public static void main(String[] args) {
        // int n = 6;
        // int[][] paths = { { 1, 2, 3 }, { 2, 3, 5 }, { 2, 4, 2 }, { 2, 5, 4 }, { 3, 4,
        // 4 }, { 4, 5, 3 }, { 4, 6, 1 },
        // { 5, 6, 1 } };
        // int[] gates = { 1, 3 };
        // int[] summits = { 5 };

        // int n = 7;
        // int[][] paths = { { 1, 4, 4 }, { 1, 6, 1 }, { 1, 7, 3 }, { 2, 5, 2 }, { 3, 7,
        // 4 }, { 5, 6, 6 } };
        // int[] gates = { 1 };
        // int[] summits = { 2, 3, 4 };

        int n = 7;
        int[][] paths = { { 1, 2, 5 }, { 1, 4, 1 }, { 2, 3, 1 }, { 2, 6, 7 }, { 4, 5, 1 }, { 5, 6, 1 }, { 6, 7, 1 } };
        int[] gates = { 3, 7 };
        int[] summits = { 1, 5 };

        Dijkstra5 test = new Dijkstra5();
        System.out.println(Arrays.toString(test.solution(n, paths, gates, summits)));
    }

    static final int INF = (int) 2e9;
    static Map<Integer, ArrayList<Node>> maps;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] types = new int[n + 1];
        for (int gate : gates) {
            types[gate] = 1;
        }
        for (int summit : summits) {
            types[summit] = 2;
        }

        maps = new HashMap<>();
        for (int[] path : paths) {
            if (types[path[0]] != 2 && types[path[1]] != 1)
                maps.computeIfAbsent(path[0], data -> new ArrayList<>()).add(new Node(path[1], path[2]));

            if (types[path[1]] != 2 && types[path[0]] != 1)
                maps.computeIfAbsent(path[1], data -> new ArrayList<>()).add(new Node(path[0], path[2]));
        }

        int[] nodes = dijkstra(n, gates);

        int[] answer = { INF, INF };
        for (int summit : summits) {
            if (answer[1] > nodes[summit]) {
                answer[0] = summit;
                answer[1] = nodes[summit];
            } else if (answer[1] == nodes[summit]) {
                if (answer[0] > summit)
                    answer[0] = summit;
            }
        }

        return answer;
    }

    public int[] dijkstra(int n, int[] gates) {
        Queue<Node> q = new LinkedList<>();

        int[] nodes = new int[n + 1];
        Arrays.fill(nodes, INF);

        for (int gate : gates) {
            q.add(new Node(gate, 0));
            nodes[gate] = 0;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.intensity < nodes[node.index] || !maps.containsKey(node.index))
                continue;

            for (Node nextNode : maps.get(node.index)) {
                int max = Math.max(nodes[node.index], nextNode.intensity);

                if (max < nodes[nextNode.index]) {
                    nodes[nextNode.index] = max;

                    q.add(new Node(nextNode.index, max));
                }
            }
        }

        return nodes;
    }

    class Node {
        public int index;
        public int intensity;

        public Node(int index, int intensity) {
            this.index = index;
            this.intensity = intensity;
        }
    }
}
