package graph;

import java.util.Arrays;

// 프로그래머스
// 섬 연결하기
// https://programmers.co.kr/learn/courses/30/lessons/42861

public class graph2 {
    static int[] union;
    public static void main(String[] args){
        int n = 4;
        int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {1, 3, 2}, {0, 3, 4}};

        Arrays.sort(costs, (a,b) -> a[2]-b[2]);
        
        union = new int[n];
        for(int i=0; i<union.length; i++){
            union[i] = i;
        }

        int answer = 0;
        for(int i=0; i<costs.length; i++){
            int first = find(costs[i][0]);
            int second = find(costs[i][1]);

            if(first != second){
                answer += costs[i][2];
                union[second] = first;
            }
        }

        System.out.println(answer);

    }

    static int find(int a){
        if(union[a] == a) return a;
        else return union[a] = find(union[a]);
    }
}