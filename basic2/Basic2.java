package basic2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Basic2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken()) / 2;

        for (int i = 0; i < height; i++) {
            String[] paint = br.readLine().split("");

            int C = width * 2 - 1;

            for (int j = 0; j < width; j++) {
                if (!paint[j].equals(".")) {
                    paint[C - j] = paint[j];
                } else if (!paint[C - j].equals(".")) {
                    paint[j] = paint[C - j];
                }
            }

            sb.append(String.join("", paint) + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
