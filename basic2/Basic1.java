package basic2;

import java.util.Scanner;

// 백준 23348

public class Basic1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] values = new int[3];
        for (int i = 0; i < 3; i++) {
            values[i] = sc.nextInt();
        }

        int T = sc.nextInt();

        int result = 0;

        for (int i = 0; i < T; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                for (int z = 0; z < values.length; z++) {
                    int skill = sc.nextInt();
                    sum += skill * values[z];
                }
            }

            result = sum > result ? sum : result;
        }

        System.out.println(result);
    }
}
