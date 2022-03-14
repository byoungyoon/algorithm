package dfs.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/92343?language=java

public class Dfs7 {
    static Map<Integer, List<Integer>> hm = new HashMap<>();
    static int answer;

    public static void main(String[] args) {
        int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };

        Dfs7 dfs = new Dfs7();
        System.out.println(dfs.solution(info, edges));
    }

    private int solution(int[] info, int[][] edges) {
        for (int[] edge : edges) {
            hm.computeIfAbsent(edge[0], data -> new ArrayList<>()).add(edge[1]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        dfs(info, 0, 0, 0, list);

        return answer;
    }

    private void dfs(int[] info, int index, int sheep, int wolf, List<Integer> list) {
        if (info[index] == 0)
            sheep++;
        else
            wolf++;

        if (wolf >= sheep)
            return;
        answer = answer > sheep ? answer : sheep;

        List<Integer> next = new ArrayList<>();
        next.addAll(list);

        if (hm.containsKey(index)) {
            next.addAll(hm.get(index));
        }
        next.remove(Integer.valueOf(index));

        for (int value : next) {
            dfs(info, value, sheep, wolf, next);
        }

        return;
    }

}
