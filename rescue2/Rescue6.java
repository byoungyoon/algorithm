package rescue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/25497

public class Rescue6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] skills = br.readLine().split("");

        Rescue6 test = new Rescue6();
        System.out.println(test.solution(skills));
    }

    public int solution(String[] skills) {
        int preR = 0;
        int preK = 0;

        int answer = 0;
        for (String skill : skills) {
            switch (skill) {
                case "L":
                    preR++;
                    break;
                case "S":
                    preK++;
                    break;
                case "R":
                    if (preR == 0)
                        return answer;
                    preR--;
                    answer++;
                    break;
                case "K":
                    if (preK == 0)
                        return answer;
                    preK--;
                    answer++;
                    break;
                default:
                    answer++;
                    break;
            }
        }

        return answer;
    }
}
