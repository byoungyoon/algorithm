package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1389

public class Floyd3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] relation = new int[T][2];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            relation[i][0] = Integer.parseInt(st.nextToken());
            relation[i][1] = Integer.parseInt(st.nextToken());
        }

        Floyd3 test = new Floyd3();
        System.out.println(test.solution(relation, N));
    }

    static int INF = (int) 1e9;

    private int solution(int[][] relation, int N) {
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < relation.length; i++) {
            map[relation[i][0]][relation[i][1]] = 1;
            map[relation[i][1]][relation[i][0]] = 1;
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] = i != j && map[i][j] == 0 ? INF : map[i][j];
            }
        }

        for (int mid = 1; mid <= N; mid++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    if (map[start][mid] + map[mid][end] < map[start][end]) {
                        map[start][end] = map[start][mid] + map[mid][end];
                    }
                }
            }
        }

        int min = INF;
        int answer = 0;
        for (int i = 1; i < map.length; i++) {
            int sum = Arrays.stream(map[i]).sum();
            if (sum < min) {
                min = sum;
                answer = i;
            }
        }

        return answer;
    }
}
