package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1967

public class Dfs19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] direction = new int[N - 1][3];
        StringTokenizer st;
        for (int i = 0; i < direction.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 3; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dfs19 test = new Dfs19();
        System.out.println(test.solution(N, direction));
    }

    static Map<Integer, List<int[]>> hm = new HashMap<>();
    static int[] node;
    static int answer = 0;

    private int solution(int N, int[][] direction) {
        for (int i = 0; i < direction.length; i++) {
            hm.computeIfAbsent(direction[i][0], data -> new ArrayList<>())
                    .add(new int[] { direction[i][1], direction[i][2] });
        }

        node = new int[N + 1];
        node[1] = dfs(1);

        return answer;
    }

    private int dfs(int index) {
        if (node[index] != 0 || !hm.containsKey(index))
            return node[index];

        List<int[]> curr = hm.get(index);
        int[] arr = new int[curr.size()];

        for (int i = 0; i < curr.size(); i++) {
            int[] target = curr.get(i);
            arr[i] = dfs(target[0]) + target[1];
        }

        Arrays.sort(arr);
        int first = arr[curr.size() - 1];
        int second = curr.size() > 1 ? arr[curr.size() - 2] : 0;

        node[index] = first;
        answer = Math.max(answer, first + second);

        return node[index];
    }
}
