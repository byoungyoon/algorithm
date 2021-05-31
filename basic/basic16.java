package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// 프로그래머스
// 문자열 내림차순으로 배치하기

public class basic16 {
    public static void main(String[] args){
        String s = "Zbcdefg";

        String sLower = Arrays.stream(s.replaceAll("[A-Z]", "").split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
        String sUpper = Arrays.stream(s.replaceAll("[a-z]", "").split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());

        System.out.println(sLower + sUpper);

    }
}
