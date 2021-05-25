package backtracking;

import java.util.HashSet;
import java.util.Set;

// 프로그래머스
// 소수 찾기

public class backtracking3 {
    static int answer = 0;
    public static void main(String[] args){
        String numbers = "011";
        boolean[] visited = new boolean[numbers.length()];
        String[] output = new String[numbers.length()];
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<numbers.length()+1; i++){
            backtracking(numbers.split(""), output, visited, numbers.length(), i, 0, set);
        }

        for(Integer i: set){
            decimal(i);
        }

        System.out.println(answer);
    }

    static void decimal(int value){
        if(value == 0 || value == 1) return;
        for(int i=2; i<value; i++){
            if(value % i == 0) return;
        }
        answer = answer + 1;
    }

    static void backtracking(String[] numbers, String[] output, boolean[] visited, int n, int r, int depth, Set<Integer> set){
        if(r == 0){
            String value = "";
            for(int i=0; i<n; i++){
                if(output[i] != null) value += output[i];
            }
            set.add(Integer.parseInt(value));
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            output[depth] = numbers[i];
            backtracking(numbers, output, visited, n, r-1, depth+1, set);
            visited[i] = false;
        }
    }
}
