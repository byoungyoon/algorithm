package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Bfs8 test = new Bfs8();
        System.out.println(test.solution(map));
    }

    static int wall = 3;
    static int safe;
    static int answer = 0;

    private int solution(int[][] map) {
        safe = map.length * map[0].length;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 || map[i][j] == 2)
                    safe -= 1;
            }
        }

        dfs(map, 0);

        return answer;
    }

    private void dfs(int[][] map, int depth) {
        if (depth == wall) {
            answer = Math.max(answer, safe - wall - bfs(map));
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(map, depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int bfs(int[][] map) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;

                    q.add(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] index = q.poll();

                        for (int z = 0; z < direction.length; z++) {
                            int nY = index[0] + direction[z][0];
                            int nX = index[1] + direction[z][1];

                            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length || map[nY][nX] != 0
                                    || visited[nY][nX])
                                continue;
                            visited[nY][nX] = true;
                            q.add(new int[] { nY, nX });

                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

}
