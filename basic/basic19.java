package basic;

import java.util.Arrays;

// 프로그래머스
// 자릿수 더하기

public class basic19 {
    public static void main(String[] args){
        int n = 123;

        System.out.println(Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).reduce(0,(a,b)-> a+b));
    }
}
