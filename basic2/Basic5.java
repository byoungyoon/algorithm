package basic2;

// https://programmers.co.kr/learn/courses/30/lessons/86051

public class Basic5 {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };

        Basic5 basic = new Basic5();
        System.out.println(basic.solution(numbers));
    }

    private int solution(int[] numbers) {
        boolean[] check = new boolean[10];
        for (int number : numbers) {
            check[number] = true;
        }

        int answer = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i])
                answer += i;
        }

        return answer;
    }
}
