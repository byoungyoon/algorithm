package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095

public class Dp6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Dp6 test = new Dp6();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(test.solution(num));
        }

        sc.close();
    }

    static int answer = 0;

    private int solution(int num) {
        answer = 0;
        dfs(num, 0);
        return answer;
    }

    private void dfs(int num, int curr) {
        if (curr == num) {
            answer++;
            return;
        }

        if (curr > num)
            return;

        dfs(num, curr + 1);
        dfs(num, curr + 2);
        dfs(num, curr + 3);
    }
}
