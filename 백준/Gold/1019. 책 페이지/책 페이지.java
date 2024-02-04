import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long num = Long.valueOf(st.nextToken());

    Main test = new Main();

    String[] answer = new String[10];
    long[] output = test.solution(num);
    for (int i = 0; i < answer.length; i++) {
      answer[i] = String.valueOf(output[i]);
    }

    System.out.println(String.join(" ", answer));
  }

  long sum[] = new long[10];

  public long[] solution(long num) {
    int pow = 0;

    while (num != 0) {
      num = minus(num, pow);
      plus(num, pow);

      for (int i = 0; i < 10; i++) {
        sum[i] += (num / 10) * Math.pow(10, pow);
      }

      pow++;
      num /= 10;
    }

    return sum;
  }

  public void plus(long num, int pow) {
    int max = num >= 9 ? 9 : (int) num;

    for (int i = 1; i <= max; i++) {
      sum[i] += Math.pow(10, pow);
    }
  }

  public long minus(long num, int pow) {
    if (num == 0 || (num % 10 == 9 && num != 9)) return num;

    String[] str = String.valueOf(num).split("");

    for (int i = 0; i < str.length; i++) {
      sum[Integer.parseInt(str[i])] += Math.pow(10, pow);
    }

    return minus(num - 1, pow);
  }
}
