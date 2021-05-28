package basic;

import java.util.Arrays;

// 프로그래머스
// 최댓값과 최솟값

public class basic13 {
    public static void main(String[] args){
        String s = "-1 -2 -3 -4";
        int[] answer = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        System.out.println(answer[0] + " " + answer[answer.length-1]);
    }
}
