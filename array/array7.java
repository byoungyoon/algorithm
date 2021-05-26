package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스
// 체육복

public class array7 {
    public static void main(String[] args){
        int n = 5;
        int[] lost = {1,2,3};
        int[] reserve = {2,3,4};

        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());

        int answer = n-lost.length;

        for(int i: lost){
            if(reserveList.indexOf(i) != -1){
                reserveList.remove((Integer)i);
                lostList.remove((Integer)i);
                answer++;
            }
        }
        
        for(Integer i: lostList){
          if(reserveList.indexOf(i-1) != -1){
            reserveList.remove((Integer)(i-1));
            answer++;
          } else if(reserveList.indexOf(i+1) != -1){
            reserveList.remove((Integer)(i+1));
            answer++;
          }
        }

        System.out.println(answer);
    }
}
