package heap;

import java.util.Collections;
import java.util.PriorityQueue;

// 프로그래머스
// 야근 지수
// https://programmers.co.kr/learn/courses/30/lessons/12927

public class heap2 {
    public static void main(String[] args){
        int n = 4;
        int[] works = {4,3,3};

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }

        for(int i=0; i<n; i++){
            int value = pq.poll()-1;
            if(value < 0) value = 0;
            pq.add(value);
        }

        long answer = 0;
        for(int i=0; i<works.length; i++){
            answer += Math.pow(pq.poll(), 2);
        }

        System.out.println(answer);
    }
}
