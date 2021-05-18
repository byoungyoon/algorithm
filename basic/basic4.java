package basic;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스
// x만큼 간격이 있는 n개의 숫자

public class basic4 {
    public static void main(String[] args){
        int x = 2;
        int n = 5;

        List<Long> answer = new ArrayList<>();
        Long value = Long.valueOf(x);
        Long count = Long.valueOf(x);
        for(int i=0; i<n; i++){
            answer.add(value);
            value = value + count;
        }

        System.out.println(answer);
    }
}
