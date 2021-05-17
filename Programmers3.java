import java.util.ArrayList;
import java.util.List;

// 프로그래머스
// 소수 만들기

public class Programmers3 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        
        boolean[] visited = new boolean[nums.length];
        int r = 3;
        List<Integer> sumList = new ArrayList<>();

        backtracking(nums, visited, 0, nums.length, r, sumList);
        System.out.println(sumList.stream().mapToInt(data->decimal(data)).sum());
    }

    static int decimal(int sum){
        for(int i=2; i<sum/2; i++){
            if(sum % i == 0) return 0;
        }

        return 1;
    }

    static void backtracking(int[] nums, boolean[] visited, int depth, int n, int r, List<Integer> sumList){
        if(r == 0){
            int sum = 0;
            for(int i=0; i<n; i++){
                if(visited[i]) sum += nums[i];
            }
            sumList.add(sum);
            return;
        }

        for(int i=depth; i<n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            backtracking(nums, visited, i+1, n, r-1, sumList);
            visited[i] = false;
        }
    }
}