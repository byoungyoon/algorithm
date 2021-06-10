package dfs.bfs;

// 프로그래머스
// N으로 표현

public class dfs1 {
    static int answer = -1;
    public static void main(String[] args){
        int N = 5;
        int number = 12;

        dfs(0, 0, N, number);

        System.out.println(answer);
    }

    static void dfs(int count, int result, int N, int number){
        if(count > 8){
            return;
        }
        
        if(count < answer || answer == -1) {
            if(result == number){
                answer = count;
                return;
            }
        }

        int tempN = N;
        for(int i=0; i<8-count; i++){
            dfs(count + i + 1, result + tempN, N, number);
            dfs(count + i + 1, result - tempN, N, number);
            dfs(count + i + 1, result * tempN, N, number);
            dfs(count + i + 1, result / tempN, N, number);

            tempN = tempN * 10 + N;
        }
    }
}
