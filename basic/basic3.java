package basic;

import java.util.Arrays;

// 프로그래머스
// 하샤드 수

public class basic3 {
    public static void main(String[] args){
        int x = 10;

        System.out.println(x % Arrays.stream(Integer.toString(x).split("")).mapToInt(Integer::parseInt).reduce(0, (a,b)-> a+b) == 0);
    }
}
