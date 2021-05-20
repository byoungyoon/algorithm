package basic;

// 프로그래머스
// 평균 구하기

import java.util.Arrays;

public class basic5 {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};

        System.out.println(Arrays.stream(arr).sum() / (double)arr.length);
    }
}
