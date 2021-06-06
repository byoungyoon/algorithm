package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스
// 나누어 떨어지는 숫자 배열

public class basic20 {
    public static void main(String[] args){
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        List<Integer> answer = Arrays.stream(arr).filter(data->data%divisor == 0).sorted().boxed().collect(Collectors.toList());

        if(answer.size() == 0) answer.add(-1);
        System.out.println(answer);
    }
}
