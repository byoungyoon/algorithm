package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/1715

public class Grid1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Grid1 test = new Grid1();
        System.out.println(test.solution(nums));
    }

    public int solution(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        int answer = 0;
        while (!(pq.size() == 1)) {
            int sum = pq.poll() + pq.poll();
            pq.offer(sum);
            answer += sum;
        }

        return answer;
    }

}
