package array;

import java.util.StringTokenizer;

public class Sliding1 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
                "01:37:44-02:02:30" };

        Sliding1 test = new Sliding1();
        System.out.println(test.solution(play_time, adv_time, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int[] time = new int[time(play_time) + 1];

        for (String log : logs) {
            StringTokenizer st = new StringTokenizer(log, "-");
            int start = time(st.nextToken());
            int end = time(st.nextToken());
            for (int i = start; i < end; i++) {
                time[i]++;
            }
        }

        int advTime = time(adv_time);

        long slide = 0;
        int index = 0;
        for (int i = 0; i < advTime; i++) {
            slide += time[i];
        }

        long max = slide;
        for (int i = advTime; i < time.length; i++) {
            slide = slide + time[i] - time[i - advTime];
            if (slide > max) {
                max = slide;
                index = i - advTime + 1;
            }
        }

        return timeStr(index);
    }

    private int time(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");

        return Integer.parseInt(st.nextToken()) * 60 * 60 + Integer.parseInt(st.nextToken()) * 60
                + Integer.parseInt(st.nextToken());
    }

    private String timeStr(int i) {
        String second = i % 60 < 10 ? "0" + i % 60 : "" + i % 60;
        i = i / 60;
        String minute = i % 60 < 10 ? "0" + i % 60 : "" + i % 60;
        String hour = i / 60 < 10 ? "0" + i / 60 : "" + i / 60;

        return hour + ":" + minute + ":" + second;
    }
}
