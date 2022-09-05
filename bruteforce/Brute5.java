package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/25494

public class Brute5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Brute5 test = new Brute5();

        StringTokenizer st;
        int[] numbers = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(test.solution(numbers));
        }
    }

    public int solution(int[] numbers) {
        int answer = 0;

        for (int i = 1; i <= numbers[0]; i++) {
            for (int j = 1; j <= numbers[1]; j++) {
                for (int z = 1; z <= numbers[2]; z++) {
                    if (onMod(i, j, z))
                        answer++;
                }
            }
        }

        return answer;
    }

    public boolean onMod(int x, int y, int z) {
        return ((x % y) == (y % z)) && ((y % z) == (z % x));
    }
}
