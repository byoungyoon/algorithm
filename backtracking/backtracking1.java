package backtracking;

// 프로그래머스
// N-Queen

public class backtracking1 {
    static int answer = 0;
    public static void main(String[] args){
        int n = 12;
        
        boolean[][] visited = new boolean[n][n];
        backtracking(visited, 0, n);

        System.out.println(answer);
    }

    static void backtracking(boolean[][] visited, int depth, int n){
        if(depth == n){
            answer++;
            return;
        }

        for(int i=0; i<n; i++){
            visited[depth][i] = true;
            if(filter(visited, depth, i, n)) backtracking(visited, depth+1, n);
            visited[depth][i] = false;                                              
        }
    }

    static boolean filter(boolean[][] visited, int depth, int i, int n){
        for(int a=0; a<n; a++){
            if(a != depth){
                if(visited[a][i]) return false;
            }
            if(a != 0){
                if(depth-a >= 0 && i-a >= 0 && visited[depth-a][i-a]) return false;
                if(depth+a < n && i+a < n && visited[depth+a][i+a]) return false;
                if(depth+a < n && i-a >= 0 && visited[depth+a][i-a]) return false;
                if(depth-a >= 0 && i+a < n && visited[depth-a][i+a]) return false;
            }
        }
        return true;
    }
}