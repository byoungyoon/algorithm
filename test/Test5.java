package test;

import java.util.Scanner;

public class Test5 {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        dp(value, 0, value[0], 0);
        dp(value, 0, value[1], 1);

        System.out.println(answer);
        sc.close();
    }

    static void dp(int[] value, int count, int sum, int index) {
        if (index >= value.length)
            return;

        if (index == value.length - 1) {
            answer = answer > sum ? answer : sum;
            return;
        }

        for (int i = 1; i < 3; i++) {
            if (index + i >= value.length)
                continue;
            if (i == 1) {
                count = count + 1;
            } else {
                count = 0;
            }

            if (count == 2 && i == 1) {
                count = 0;
                continue;
            }

            dp(value, count, sum + value[index + i], index + i);
        }
    }
}
