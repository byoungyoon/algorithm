package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11404

public class Floyd2 {
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());

        int[][] direction = new int[T][3];
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Floyd2 test = new Floyd2();
        int[][] result = test.solution(direction, N);
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (result[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private int[][] solution(int[][] direction, int N) {
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (map[i][j] == 0 && i != j)
                    map[i][j] = INF;
            }
        }
        for (int i = 0; i < direction.length; i++) {
            map[direction[i][0]][direction[i][1]] = Math.min(map[direction[i][0]][direction[i][1]], direction[i][2]);
        }

        for (int mid = 1; mid <= N; mid++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    if (map[start][mid] + map[mid][end] < map[start][end])
                        map[start][end] = map[start][mid] + map[mid][end];
                }
            }
        }

        return map;
    }
}
