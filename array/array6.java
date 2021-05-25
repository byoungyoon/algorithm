package array;

import java.util.Arrays;
import java.util.stream.Collectors;

// 프로그래머스
// 카펫

public class array6 {
    public static void main(String[] args){
        int brown = 10;
        int yellow = 2;

        int sum = brown + yellow;

        int[] answer = new int[2];

        for(int i=1; i<= sum/2; i++){
            if(sum % i == 0){
                int answerX = i;
                int answerY = sum/i;

                if(answerX*2 + answerY*2 - 4 == brown){
                    answer[0] = answerX;
                    answer[1] = answerY;
                }
            }
        }

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}
