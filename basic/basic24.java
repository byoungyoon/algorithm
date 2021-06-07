package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// 프로그래머스
// 정수 내림차순으로 배치하기

public class basic24 {
    public static void main(String[] args){
        long n = 118372;

        String answer = Arrays.stream(String.valueOf(n).split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
        System.out.println(Long.valueOf(answer));
    }
}
