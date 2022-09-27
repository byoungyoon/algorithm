package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2437

public class Grid5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Grid5 test = new Grid5();
        System.out.println(test.solution(nums));
    }

    public int solution(int[] nums) {
        Arrays.sort(nums);

        int sum = nums[0];
        if (sum > 1)
            return 1;

        for (int i = 1; i < nums.length; i++) {
            if (sum + 1 < nums[i])
                break;

            sum += nums[i];
        }

        return sum + 1;
    }
}
