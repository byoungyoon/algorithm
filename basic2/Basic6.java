package basic2;

public class Basic6 {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        Basic6 basic = new Basic6();
        System.out.println(basic.solution(left, right));
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (divisor(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    public int divisor(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0)
                result++;
        }

        return result;
    }
}
