package basic;

import java.util.Arrays;

// 프로그래머스
// 제일 작은 수 제거하기

public class basic9 {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};

        int[] arrValue = Arrays.stream(arr).sorted().toArray();
        int[] arrNotValue = {-1};
        
        System.out.println(arr.length == 1?arrNotValue: Arrays.stream(arr).filter(data-> data!=arrValue[0]).toArray());

    }
}
