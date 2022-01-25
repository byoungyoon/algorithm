package rescue;

public class Rescue22 {
    public static void main(String[] args) {
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;

        Rescue22 test = new Rescue22();
        System.out.println(test.solution(n, t, m, p));
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        int order = 1;
        while (answer.length() != t) {
            String value = binary(n, num);

            for (int i = 0; i < value.length(); i++) {
                if (order == p) {
                    answer += value.charAt(i);
                    if (answer.length() == t)
                        break;
                }

                order++;
                if (order > m)
                    order = 1;
            }

            num++;
        }

        return answer;
    }

    private String binary(int n, int num) {
        if (num == 0)
            return "0";

        String[] str = { "A", "B", "C", "D", "E", "F" };

        String result = "";
        while (num > 0) {
            int value = num % n;
            if (value >= 10) {
                result = str[value - 10] + result;
            } else {
                result = num % n + result;
            }

            num = num / n;
        }

        return result;
    }
}
