package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2589

public class Bfs18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        String[][] map = new String[H][W];

        Bfs18 test = new Bfs18();
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().split("");
        }
        System.out.println(test.solution(map));
    }

    static final int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int solution(String[][] map) {
        Queue<int[]> q;
        boolean[][] visited;

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals("W"))
                    continue;
                visited = new boolean[map.length][map[0].length];
                q = new LinkedList<>();

                q.add(new int[] { i, j, 0 });
                visited[i][j] = true;
                int temp = 0;
                while (!q.isEmpty()) {
                    int[] curr = q.poll();

                    for (int z = 0; z < direction.length; z++) {
                        int nY = curr[0] + direction[z][0];
                        int nX = curr[1] + direction[z][1];

                        if (nY < 0 || nY >= map.length || nX < 0 || nX >= map[0].length || visited[nY][nX]
                                || map[nY][nX].equals("W"))
                            continue;
                        visited[nY][nX] = true;

                        temp = curr[2] + 1;
                        q.add(new int[] { nY, nX, temp });
                    }
                }
                answer = Math.max(answer, temp);
            }
        }

        return answer;
    }
}
