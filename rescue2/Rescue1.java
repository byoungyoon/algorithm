package rescue2;

// https://programmers.co.kr/learn/courses/30/lessons/17687

public class Rescue1 {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;

        Rescue1 rescue = new Rescue1();
        System.out.println(rescue.solution(n, t, m, p));
    }

    static String[] excess = { "A", "B", "C", "D", "E", "F" };

    public String solution(int n, int t, int m, int p) {
        String result = "0";

        int count = 1;
        while (result.length() < m * t) {
            result += onDecimal(n, count);
            count++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i < result.length(); i += m) {
            answer.append(result.charAt(i));
        }

        return answer.toString().substring(0, t);
    }

    public String onDecimal(int n, int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int temp = num % n;
            num /= n;
            if (temp >= 10) {
                sb.insert(0, excess[temp - 10]);
                continue;
            }
            sb.insert(0, temp);
        }

        return sb.toString();
    }
}
