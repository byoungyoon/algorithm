package basic2;

// https://programmers.co.kr/learn/challenges

public class Basic8 {
    public static void main(String[] args) {
        int n = 10;

        Basic8 basic = new Basic8();
        System.out.println(basic.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = n - 1; i > 0; i--) {
            if (n % i == 1)
                answer = i;
        }

        return answer;
    }
}
