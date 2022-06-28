package rescue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5557

public class Rescue3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Rescue3 test = new Rescue3();
        System.out.println(test.solution(N, nums));
    }

    private long solution(int N, int[] nums) {
        long[] result = new long[21];
        result[nums[0]]++;

        for (int i = 1; i < nums.length - 1; i++) {
            long[] temp = new long[21];
            for (int j = 0; j < 21; j++) {
                if (result[j] == 0)
                    continue;

                int min = j - nums[i];
                int max = j + nums[i];

                if (min >= 0)
                    temp[min] += result[j];
                if (max <= 20)
                    temp[max] += result[j];
            }
            result = temp.clone();
        }

        return result[nums[N - 1]];
    }
}
