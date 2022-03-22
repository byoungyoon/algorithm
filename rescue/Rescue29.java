package rescue;

// https://programmers.co.kr/learn/courses/30/lessons/42883

public class Rescue29 {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;

        Rescue29 rescue = new Rescue29();
        System.out.println(rescue.solution(number, k));
    }

    public String solution(String number, int k) {
        int index = 0;

        int len = number.length() - k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }

            sb.append(max);
        }

        return sb.toString();
    }
}
