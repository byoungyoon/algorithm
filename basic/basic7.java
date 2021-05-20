package basic;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

// 프로그래머스
// 음양 더하기

public class basic7 {
    public static void main(String[] args){
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        AtomicInteger index = new AtomicInteger();

        System.out.println(Arrays.stream(absolutes).map(data->signs[index.getAndIncrement()]? data: -1*data).sum());
    }
}
