package grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11000
// 살짝 문제 이해가 잘 안되는 문제
// 핵심은 수업하나가 끝났다면 수업하나를 이어갈 수 있음

public class Grid6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Grid6 test = new Grid6();
        System.out.println(test.solution(time));
    }

    public int solution(int[][] time) {
        Queue<Time> pq = new PriorityQueue<>();
        for (int i = 0; i < time.length; i++) {
            pq.offer(new Time(time[i][0], time[i][1]));
        }

        Queue<Integer> stay = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Time t1 = pq.poll();

            if (stay.isEmpty()) {
                stay.offer(t1.end);
            } else {
                if (t1.start >= stay.peek()) {
                    stay.poll();
                }
                stay.offer(t1.end);
            }
        }

        return stay.size();
    }

    class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (o.start == this.start)
                return this.end - o.end;

            return this.start - o.start;
        }
    }
}
