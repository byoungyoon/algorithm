package kakao2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/118668

public class Kakao3 {
    public static void main(String[] args) {
        int alp = 0;
        int cop = 0;
        int[][] problems = { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } };

        Kakao3 test = new Kakao3();
        System.out.println(test.solution(alp, cop, problems));
    }

    static int INF = (int) 2e9;

    public int solution(int alp, int cop, int[][] problems) {
        int mAlp = 0;
        int mCop = 0;
        for (int[] problem : problems) {
            mAlp = Math.max(mAlp, problem[0]);
            mCop = Math.max(mCop, problem[1]);
        }

        int[][] map = new int[150 + 1][150 + 1];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], INF);
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(alp, cop, 0));
        map[alp][cop] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int nAlp = Math.min(mAlp, curr.alp + 1);
            int nCop = Math.min(mCop, curr.cop + 1);

            if (map[nAlp][curr.cop] > curr.value + 1) {
                map[nAlp][curr.cop] = curr.value + 1;
                q.offer(new Node(nAlp, curr.cop, curr.value + 1));
            }
            if (map[curr.alp][nCop] > curr.value + 1) {
                map[curr.alp][nCop] = curr.value + 1;
                q.offer(new Node(curr.alp, nCop, curr.value + 1));
            }

            for (int[] problem : problems) {
                if (curr.alp < problem[0] || curr.cop < problem[1])
                    continue;

                nAlp = Math.min(mAlp, curr.alp + problem[2]);
                nCop = Math.min(mCop, curr.cop + problem[3]);
                if (map[nAlp][nCop] > curr.value + problem[4]) {
                    map[nAlp][nCop] = curr.value + problem[4];
                    q.offer(new Node(nAlp, nCop, curr.value + problem[4]));
                }
            }

        }

        return map[mAlp][mCop];
    }

    class Node {
        int alp;
        int cop;
        int value;

        public Node(int alp, int cop, int value) {
            this.alp = alp;
            this.cop = cop;
            this.value = value;
        }
    }
}
