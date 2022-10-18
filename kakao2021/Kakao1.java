package kakao2021;

// https://school.programmers.co.kr/learn/courses/30/lessons/81301

public class Kakao1 {
    public static void main(String[] args) {
        String s = "one4seveneight";

        Kakao1 test = new Kakao1();
        System.out.println(test.solution(s));
    }

    public int solution(String s) {
        String[] str = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < str.length; i++)
            s = s.replaceAll(str[i], i + "");

        return Integer.parseInt(s);
    }
}
