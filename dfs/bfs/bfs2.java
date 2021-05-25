package dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스
// 타겟 넘버

public class bfs2 {
    public static void main(String[] args){
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        Queue<Integer> q = new LinkedList<>();
        q.offer(numbers[0]);
        q.offer(-1*numbers[0]);

        bfs(numbers, q, 1);

        System.out.println(count(q, target));
    }

    static int count(Queue<Integer> q, int target){
        int answer = 0;
        while(!q.isEmpty()){
            if(q.poll() == target) answer++;
        }

        return answer;
    }

    static void bfs(int[] numbers, Queue<Integer> q, int index){
        if(numbers.length == index) return;
        int size = q.size();
        for(int i=0; i<size; i++){
            int value = q.poll();
            q.offer(value + numbers[index]);
            q.offer(value - numbers[index]);
            
        }

        bfs(numbers, q, index+1);
    }
}
