package basic;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

// 프로그래머스
// 내적

class basic6{
    public static void main(String[] args){
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        AtomicInteger index = new AtomicInteger();

        System.out.println(Arrays.stream(a).map(data->data* b[index.getAndIncrement()]).sum());
    }
}