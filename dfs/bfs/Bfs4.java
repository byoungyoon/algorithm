package dfs.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/67260

public class Bfs4 {
    public static void main(String[] args) {
        int n = 9;
        int[][] path = { { 0, 1 }, { 0, 3 }, { 0, 7 }, { 8, 1 }, { 3, 6 }, { 1, 2 }, { 4, 7 }, { 7, 5 } };
        int[][] order = { { 8, 5 }, { 6, 7 }, { 4, 1 } };

        Bfs4 bfs = new Bfs4();
        System.out.println(bfs.solution(n, path, order));
    }

    private boolean solution(int n, int[][] path, int[][] order) {
        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        for (int[] p : path) {
            pathMap.computeIfAbsent(p[1], data -> new ArrayList<>()).add(p[0]);
            pathMap.computeIfAbsent(p[0], data -> new ArrayList<>()).add(p[1]);
        }

        int[] before = new int[n];
        for (int[] o : order) {
            before[o[1]] = o[0];
        }
        if (before[0] != 0)
            return false;

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> q = new LinkedList<>();
        for (int i : pathMap.get(0)) {
            q.offer(i);
        }

        bfs(pathMap, before, q, visited);

        return allNodeCk(visited);
    }

    private boolean allNodeCk(boolean[] visited) {
        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    private void bfs(Map<Integer, List<Integer>> pathMap, int[] before, Queue<Integer> q,
            boolean[] visited) {
        int[] save = new int[before.length];
        while (!q.isEmpty()) {
            int index = q.poll();

            if (visited[index])
                continue;

            if (!visited[before[index]]) {
                save[before[index]] = index;
                continue;
            }
            System.out.println(index);

            visited[index] = true;
            for (int i : pathMap.get(index)) {
                q.offer(i);
            }

            q.offer(save[index]);
        }
    }
}
