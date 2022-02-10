package rescue;

import java.util.Arrays;

public class Rescue23 {
    static final String START_TIME = "09:00";

    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 3;
        String[] timetable = { "09:05", "09:09", "09:13" };

        Rescue23 rescue = new Rescue23();
        System.out.println(rescue.solution(n, t, m, timetable));
    }

    private String solution(int n, int t, int m, String[] timetable) {
        int[] value = new int[timetable.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = time(timetable[i]);
        }
        Arrays.sort(value);

        int current = time(START_TIME);
        int index = 0;

        String answer = START_TIME;
        while (n-- > 0) {
            if (n == 0) {
                if (timetable.length - index < m) {
                    answer = timeStr(current);
                } else {
                    int pre = value[index + m - 1];
                    answer = pre > current ? timeStr(current) : timeStr(pre - 1);
                }
            } else {
                int count = 0;
                for (int i = index; i < timetable.length; i++) {
                    if (value[i] > current || count >= m) {
                        index = i;
                        break;
                    }
                    count++;
                }

                current += t;
            }
        }

        return answer;
    }

    private int time(String time) {
        String[] value = time.split(":");
        return Integer.parseInt(value[0]) * 60 + Integer.parseInt(value[1]);
    }

    private String timeStr(int time) {
        String hour = time / 60 < 10 ? "0" + time / 60 : "" + time / 60;
        String min = time % 60 < 10 ? "0" + time % 60 : "" + time % 60;
        return hour + ":" + min;
    }

}