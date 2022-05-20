package dp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10942

public class Dp16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Dp16 dp = new Dp16();
        dp.setMap(arr);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            bw.write(dp.getMap(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())) + "\n");
        }

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        bw.flush();
        bw.close();
    }

    static int[][] map;

    private int getMap(int start, int end) {
        return map[start - 1][end - 1];
    }

    private void setMap(int[] arr) {
        map = new int[arr.length][arr.length];

        map[0][0] = 1;
        for (int i = 1; i < arr.length; i++) {
            map[i][i] = 1;
            if (arr[i - 1] == arr[i])
                map[i - 1][i] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            for (int end = i; end < arr.length; end++) {
                int start = end - i;
                if (arr[start] == arr[end] && map[start + 1][end - 1] == 1) {
                    map[start][end] = 1;
                }
            }
        }
    }
}
