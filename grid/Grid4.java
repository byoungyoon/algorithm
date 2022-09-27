package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1744
// 핵심은 0을 기준으로 양 옆 그룹을 나눈다
// 단, 1일 경우 곱하면 더 작아지기 때문에 더해주는 예외가 존재한다

public class Grid4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Grid4 test = new Grid4();
        System.out.println(test.solution(nums));
    }

    public int solution(int[] nums) {
        Arrays.sort(nums);

        int answer = 0;
        for (int i = nums.length - 1; i >= 0; i -= 2) {
            if (i == 0) {
                if (nums[i] > 0)
                    answer += nums[i];
                continue;
            }

            if (nums[i - 1] <= 0) {
                if (nums[i] > 0)
                    answer += nums[i];
                break;
            }

            if (nums[i - 1] == 1 || nums[i] == 1)
                answer += nums[i] + nums[i - 1];
            else
                answer += nums[i] * nums[i - 1];
        }

        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1) {
                if (nums[i] < 0)
                    answer += nums[i];
                continue;
            }

            if (nums[i + 1] > 0) {
                if (nums[i] < 0)
                    answer += nums[i];
                break;
            }

            answer += nums[i] * nums[i + 1];
        }

        return answer;
    }
}
