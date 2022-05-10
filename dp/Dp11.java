package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/14501

public class Dp11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            int[] tempInt = { Integer.parseInt(temp[0]), Integer.parseInt(temp[1]) };

            time[i] = tempInt;
        }

        Dp11 dp = new Dp11();
        System.out.println(dp.solution(n, time));

        sc.close();
    }

    static int answer = 0;

    private int solution(int n, int[][] time) {
        dfs(n, time, 0, 0);
        return answer;
    }

    private void dfs(int n, int[][] time, int depth, int count) {
        if (depth == n) {
            answer = answer < count ? count : answer;
            return;
        }

        if (depth > n)
            return;

        dfs(n, time, depth + time[depth][0], count + time[depth][1]);
        dfs(n, time, depth + 1, count);
    }
}
