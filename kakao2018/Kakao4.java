package kakao2018;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/17682

public class Kakao4 {
    public static void main(String[] args) {
        String dartResult = "1D2S#10S";

        Kakao4 test = new Kakao4();
        System.out.println(test.solution(dartResult));
    }

    public int solution(String dartResult) {
        String[] nums = dartResult.split("[^0-9]+");
        String[] values = dartResult.split("[0-9]+");
        values = Arrays.copyOfRange(values, 1, values.length);

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);

            switch (values[i].charAt(0)) {
                case 'D':
                    num = (int) Math.pow(num, 2);
                    break;
                case 'T':
                    num = (int) Math.pow(num, 3);
                    break;
                default:
                    break;
            }

            result[i] = num;

            if (values[i].length() == 1)
                continue;

            switch (values[i].charAt(1)) {
                case '*':
                    if (i - 1 >= 0)
                        result[i - 1] *= 2;
                    result[i] *= 2;
                    break;
                case '#':
                    result[i] *= -1;
                    break;
                default:
                    break;
            }
        }

        return Arrays.stream(result).sum();
    }
}
