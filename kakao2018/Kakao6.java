package kakao2018;

import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/17678

public class Kakao6 {
    public static void main(String[] args) {
        int n = 2;
        int t = 1;
        int m = 2;
        String[] timetable = { "09:00", "09:00", "09:00", "09:00" };

        Kakao6 test = new Kakao6();
        System.out.println(test.solution(n, t, m, timetable));
    }

    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (String str : timetable) {
            pq.offer(timeToMin(str));
        }

        int time = timeToMin("09:00");
        int result = 0;
        for (int i = 0; i < n; i++) {
            int weight = m;
            int last = 0;
            while (!pq.isEmpty() && weight != 0) {
                if (pq.peek() > time)
                    break;

                weight--;
                last = pq.poll();
            }

            if (weight == 0) {
                result = last - 1;
            } else {
                result = time;
            }

            time += t;
        }

        return minToTime(result);
    }

    public int timeToMin(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public String minToTime(int time) {
        int hour = time / 60;
        int min = time % 60;

        return (hour < 10 ? "0" : "") + hour + ":" + (min < 10 ? "0" : "") + min;
    }
}
