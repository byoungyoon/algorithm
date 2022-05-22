package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2407

public class Dp18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Dp18 dp = new Dp18();
        System.out.println(dp.solution(n, m));
    }

    private BigInteger solution(int n, int m) {
        return combination(n, m);
    }

    private BigInteger combination(int n, int r) {
        r = n - r < r ? n - r : r;

        BigInteger result = new BigInteger("1");
        BigInteger temp;
        for (int i = 0; i < r; i++) {
            temp = BigInteger.valueOf(n - i);
            result = result.multiply(temp);
        }

        for (int i = 0; i < r; i++) {
            temp = BigInteger.valueOf(r - i);
            result = result.divide(temp);
        }

        return result;
    }
}
