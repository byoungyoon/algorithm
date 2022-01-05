import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test11 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
                "01:37:44-02:02:30" };

        Test11 test = new Test11();
        System.out.println(test.solution(play_time, adv_time, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        return answer;
    }
}
