package rescue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/25495

public class Rescue4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tels = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < tels.length; i++) {
            tels[i] = Integer.parseInt(st.nextToken());
        }

        Rescue4 test = new Rescue4();
        System.out.println(test.solution(tels));
    }

    public int solution(int[] tels) {
        int nums[] = new int[tels.length + 1];
        nums[0] = 0;
        nums[1] = 2;

        for (int i = 1; i < tels.length; i++) {
            if (tels[i] != tels[i - 1] || nums[i] == 0) {
                nums[i + 1] = nums[i] + 2;
            } else {
                nums[i + 1] = nums[i] + (nums[i] - nums[i - 1]) * 2;
            }

            if (nums[i + 1] >= 100) {
                nums[i + 1] = 0;
            }
        }

        return nums[tels.length];
    }
}
