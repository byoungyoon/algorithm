package rescue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1010

public class Rescue32 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Rescue32 rescue = new Rescue32();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(rescue.solution(n, r));
        }

    }

    private long solution(int n, int r) {
        return combination(n, r);
    }

    private long combination(int n, int r) {
        long result = 1;

        r = r > n / 2 ? n - r : r;
        int temp = r;
        for (int i = 0; i < temp; i++) {
            result *= n;
            n--;
        }

        for (int i = 0; i < temp; i++) {
            result /= r;
            r--;
        }

        return result;
    }
}
