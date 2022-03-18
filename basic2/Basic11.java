package basic2;

// https://programmers.co.kr/learn/courses/30/lessons/12934?language=java

public class Basic11 {
    public static void main(String[] args) {
        long n = 121;

        Basic11 basic = new Basic11();
        System.out.println(basic.solution(n));
    }

    public long solution(long n) {
        double sqrtN = Math.sqrt(n);
        if (sqrtN < Math.ceil(sqrtN)) {
            return -1;
        }

        return ((long) sqrtN + 1) * ((long) sqrtN + 1);
    }
}
