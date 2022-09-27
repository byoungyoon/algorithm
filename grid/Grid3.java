package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1202
// 그리드 문제로 일반적인 메모라이징 방식이 특이하다.
// 보석의 value를 계속 저장한 상태에서 해당하는 최대값만 뽑아내는 방식

public class Grid3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Grid3 test = new Grid3();
        System.out.println(test.solution(jewel, bag));
    }

    public long solution(int[][] jewel, int[] bag) {
        Arrays.sort(jewel, new CustomComparator());
        Arrays.sort(bag);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;

        for (int i = 0, j = 0; i < bag.length; i++) {
            while (j < jewel.length && jewel[j][0] <= bag[i]) {
                pq.offer(jewel[j++][1]);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        return answer;
    }

    class CustomComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        }
    }

}
