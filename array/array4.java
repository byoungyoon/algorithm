package array;

import java.util.Arrays;

// 프로그래머스
// 자연수 뒤집어 배열로 만들기

public class array4 {
    public static void main(String[] args){
        long n = 12345;
        int[] nArray = Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[nArray.length];

        for(int i=0; i<nArray.length; i++){
            answer[nArray.length - i - 1] = nArray[i];
        }

        System.out.println(answer);
    }    
}
