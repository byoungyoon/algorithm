package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/118668

public class Dijkstra6 {
    public static void main(String[] args) {
        // int alp = 10;
        // int cop = 10;
        // int[][] problems = { { 10, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } };

        int alp = 0;
        int cop = 0;
        int[][] problems = { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2
        }, { 10, 4, 0, 4, 2 } };

        Dijkstra6 test = new Dijkstra6();
        System.out.println(test.solution(alp, cop, problems));
    }

    static final int INF = (int) 2e9;

    public int solution(int alp, int cop, int[][] problems) {
        int mAlp = 0;
        int mCop = 0;

        for (int[] problem : problems) {
            mAlp = Math.max(mAlp, problem[0]);
            mCop = Math.max(mCop, problem[1]);
        }

        int[][] maps = new int[mAlp + 1][mCop + 1];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(maps[i], INF);
        }

        Queue<Node> q = new LinkedList<>();

        alp = Math.min(alp, mAlp);
        cop = Math.min(cop, mCop);
        q.add(new Node(alp, cop, 0));
        maps[alp][cop] = 0;

        int answer = INF;
        List<int[]> direction = new ArrayList<>();

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.cos >= answer)
                continue;

            if (node.alp == mAlp && node.cop == mCop) {
                answer = Math.min(answer, node.cos);
                continue;
            }

            direction.clear();
            direction.add(new int[] { Math.min(mAlp, node.alp + 1), node.cop, node.cos + 1 });
            direction.add(new int[] { node.alp, Math.min(mCop, node.cop + 1), node.cos + 1 });
            for (int[] problem : problems) {
                if (node.alp < problem[0] || node.cop < problem[1])
                    continue;

                direction.add(new int[] { Math.min(mAlp, node.alp + problem[2]), Math.min(mCop, node.cop + problem[3]),
                        node.cos + problem[4] });
            }

            for (int i = 0; i < direction.size(); i++) {
                int[] next = direction.get(i);

                if (maps[next[0]][next[1]] <= next[2])
                    continue;

                maps[next[0]][next[1]] = next[2];
                q.add(new Node(next[0], next[1], next[2]));
            }

        }

        return answer;
    }

    class Node {
        public int alp;
        public int cop;
        public int cos;

        public Node(int alp, int cop, int cos) {
            this.alp = alp;
            this.cop = cop;
            this.cos = cos;
        }
    }
}
