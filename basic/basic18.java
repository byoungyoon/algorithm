package basic;

import java.util.Arrays;
import java.util.stream.Collectors;

// 프로그래머스
// 서울에서 김서방 찾기

public class basic18 {
    public static void main(String[] args){
        String[] seoul = {"Jane", "Kim"};


        System.out.println("김서방은 " + Arrays.stream(seoul).collect(Collectors.toList()).indexOf("Kim") + "에 있다");
    }
}
