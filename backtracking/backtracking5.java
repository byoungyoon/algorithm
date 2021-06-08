package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스
// 가장 큰 수 
// 순열로 풀었으나 순열로는 정답 측정을 해주지 않는다....

public class backtracking5 {
    static Long join = 0L;
    public static void main(String[] args){
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12};

        String answer = "";

        List<String> numbersStr = Arrays.stream(numbers).mapToObj(data->Integer.toString(data)).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        
        char frist = numbersStr.get(0).charAt(0);
        List<String> overlap = new ArrayList<>(){{
            add(numbersStr.get(0));
        }};

        for(int i=1; i<numbersStr.size(); i++){
            if(frist != numbersStr.get(i).charAt(0)){
                frist = numbersStr.get(i).charAt(0);
                
                if(overlap.size() > 1){
                    overlap.add(numbersStr.get(i));

                    boolean[] visited = new boolean[overlap.size()];
                    List<String> result = new ArrayList<>();
                    backtracking(overlap, visited, 0, result);

                    answer += join;
                    join = 0L;
                    overlap.clear();
                    continue;
                } else{
                    answer += overlap.get(0);
                    overlap.clear();
                }
            }
            overlap.add(numbersStr.get(i));
        }

        if(overlap.size() == 1){
            answer += overlap.get(0);
        } else{
            boolean[] visited = new boolean[overlap.size()];
            List<String> result = new ArrayList<>();
            backtracking(overlap, visited, 0, result);

            answer += join;
        }

        System.out.println(answer);

    }

    static void backtracking(List<String> overlap, boolean[] visited, int depth, List<String> result){
        if(depth == overlap.size()){
            join = Long.parseLong(String.join("", result)) > join? Integer.parseInt(String.join("", result)):join;
            return;
        }

        for(int i=0; i<overlap.size(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            result.add(overlap.get(i));
            backtracking(overlap, visited, depth+1, result);
            result.remove(overlap.get(i));
            visited[i] = false;
        }
    }
}
