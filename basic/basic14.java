package basic;

import java.util.Arrays;

// 프로그래머스
// 예산

public class basic14 {
    public static void main(String[] args){
        int[] d = {2, 2, 3, 3};
        int budget = 10;

        int answer = 0;
        Arrays.sort(d);

        for(int i: d){
            budget = budget - i;
            if(budget < 0) System.out.println(answer);
            answer++;
        }
    }
}
