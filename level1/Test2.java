package level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108

public class Test2 {
    public static void main(String[] args) {
        String s = "abracadabra";

        Test2 test = new Test2();
        System.out.println(test.solution(s));
    }

    public int solution(String s) {
        int answer = 0;

        while (s.length() != 0) {
            answer++;

            char ch = s.charAt(0);
            int sCount = 1;
            int dCount = 0;
            for (int i = 1; i < s.length(); i++) {
                if (ch == s.charAt(i))
                    sCount++;
                else
                    dCount++;

                if (sCount == dCount)
                    break;
            }

            s = s.substring(sCount + dCount);
            System.out.println(s);
        }

        return answer;
    }
}
