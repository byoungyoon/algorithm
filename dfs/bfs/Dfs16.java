package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2583

public class Dfs16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[K][4];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dfs16 test = new Dfs16();
        List<Integer> answer = test.solution(arr, N, M);

        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private List<Integer> solution(int[][] arr, int N, int M) {
        List<Integer> answer = new ArrayList<>();

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i][1]; j < arr[i][3]; j++) {
                for (int z = arr[i][0]; z < arr[i][2]; z++) {
                    if (!visited[j][z])
                        visited[j][z] = true;
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    answer.add(dfs(visited, i, j, 1));
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    private int dfs(boolean[][] visited, int y, int x, int depth) {
        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= visited.length || nX >= visited[0].length || visited[nY][nX])
                continue;

            visited[nY][nX] = true;
            depth = dfs(visited, nY, nX, depth + 1);
        }

        return depth;
    }
}
