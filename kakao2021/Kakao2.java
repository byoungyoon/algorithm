package kakao2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/81302

public class Kakao2 {
    public static void main(String[] ars) {
        String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

        Kakao2 test = new Kakao2();
        System.out.println(Arrays.toString(test.solution(places)));
    }

    Queue<int[]> q;
    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            q = new LinkedList<>();
            for (int j = 0; j < 5; j++) {
                for (int z = 0; z < 5; z++) {
                    if (places[i][j].charAt(z) == 'P')
                        q.offer(new int[] { j, z, j, z, 0 });
                }
            }

            answer[i] = bfs(places[i]) ? 1 : 0;
        }

        return answer;
    }

    public boolean bfs(String[] map) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < direction.length; i++) {
                int nY = curr[0] + direction[i][0];
                int nX = curr[1] + direction[i][1];

                if (nY < 0 || nX < 0 || nY >= 5 || nX >= 5 || map[nY].charAt(nX) == 'X' || curr[4] == 2)
                    continue;
                if (nY == curr[2] && nX == curr[3])
                    continue;

                if (map[nY].charAt(nX) == 'P')
                    return false;

                q.offer(new int[] { nY, nX, curr[2], curr[3], curr[4] + 1 });
            }
        }

        return true;
    }
}
