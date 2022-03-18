package basic2;

// https://programmers.co.kr/learn/courses/30/lessons/82612

public class Basic9 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        Basic9 basic = new Basic9();
        System.out.println(basic.solution(price, money, count));
    }

    public long solution(int price, int money, int count) {
        long answer = money;

        long sum = price;
        for (int i = 1; i <= count; i++) {
            answer -= sum;
            sum += price;
        }

        if (answer > 0)
            return 0;

        return answer * -1;
    }
}
