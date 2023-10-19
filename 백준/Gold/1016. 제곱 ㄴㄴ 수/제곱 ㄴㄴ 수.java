import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long min = Long.valueOf(st.nextToken());
    long max = Long.valueOf(st.nextToken());

    Main test = new Main();
    System.out.println(test.solution(min, max));
  }

  public long solution(long min, long max) {
    boolean[] check = new boolean[(int) (max - min + 1)];
    long curr = 2;

    while (curr * curr <= max) {
      long square = curr * curr;

      long start = min < square ? square : min;
      if (start % square != 0) start += square - (start % square);

      for (long i = start; i <= max; i += square) {
        check[(int) (i - min)] = true;
      }

      curr++;
    }

    long answer = 0;
    for (int i = 0; i < check.length; i++) {
      if (!check[i]) answer++;
    }

    return answer;
  }
}
