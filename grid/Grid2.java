package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1339

public class Grid2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Grid2 test = new Grid2();
        System.out.println(test.solution(words));
    }

    public int solution(String[] words) {
        int[] nums = new int[26];
        for (String word : words) {
            char[] ch = word.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                nums[ch[i] - 'A'] += Math.pow(10, (ch.length - 1) - i);
            }
        }

        Arrays.sort(nums);

        int answer = 0;

        int count = 9;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count == 0)
                break;

            if (nums[i] == 0)
                continue;

            answer += nums[i] * count;
            count--;
        }

        return answer;
    }
}
