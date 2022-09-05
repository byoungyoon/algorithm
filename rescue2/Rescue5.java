package rescue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/25496

public class Rescue5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Rescue5 test = new Rescue5();
        System.out.println(test.solution(P, values));
    }

    static final int MAX = 200;

    public int solution(int P, int[] values) {
        int answer = 0;

        if (P >= MAX)
            return answer;

        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
            P += values[i];
            answer++;

            if (P >= MAX)
                break;
        }

        return answer;
    }
}
