package rescue;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

// 프로그래머스
// 이상한 문자 만들기

public class rescue1 {
    public static void main(String[] args){
        String s = "try hello world";

        String[] array = s.split(" ", -1);
        StringJoiner stringJoiner = new StringJoiner(" ","","");
        for(String ss: array){
            AtomicInteger index = new AtomicInteger();
            stringJoiner.add(Arrays.stream(ss.split("")).reduce("",(a,b)->index.getAndIncrement()%2==0?a+b.toUpperCase():a+b.toLowerCase()));
        }

        String answer = stringJoiner.toString();

        System.out.println(answer);
    }
}
