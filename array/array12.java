package array;

import java.util.Arrays;

// 프로그래머스
// 단속카메라
// https://programmers.co.kr/learn/courses/30/lessons/42884

public class array12 {
    public static void main(String[] args){
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};

        Arrays.sort(routes, (a,b)-> Integer.compare(a[1], b[1]));

        int answer = 0;

        int min = -30001;
        for(int[] route: routes){
            if(min < route[0]){
                min = route[1];
                answer = answer + 1;
            }
        }

        System.out.println(answer);
    }
}
