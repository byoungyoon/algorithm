package basic;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스
// 같은 숫자는 싫어

public class basic15 {
    public static void main(String[] args){
        int [] arr = {1,1,3,3,0,1,1};
        
        int value = -1;
        List<Integer> answer = new ArrayList<>();

        for(int i: arr){
            if(value != i){
                value = i;
                answer.add(value);
            }
        }

        System.out.println(answer);
    }
}
