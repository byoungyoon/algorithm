package backtracking;

public class backtracking1 {
    static int answer = 0;
    public static void main(String[] args){
        int n = 4;
        
        boolean[][] visited = new boolean[n][n];
        backtracking(visited, 0, n);

        System.out.println(answer);
    }

    static void backtracking(boolean[][] visited, int depth, int n){
        if(depth == n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visited[i][j]){
                        for(int a=0; a<n; a++){
                            // if(visited[a][j] && a != i) return;
                            // if(visited[i][a] && a != j) return;
                            // if(a != 0 && i-a >= 0 && j-a >= 0 && visited[i-a][j-a]) return;
                            // if(a != 0 && i+a < n && j+a < n && visited[i+a][j+a]) return;
                            // if(a != 0 && i+a < n && j-a >= 0 && visited[i+a][j-a]) return;
                            // if(a != 0 && i-a >= 0 && j+a < n && visited[i-a][j+a]) return;
                        }
                    }
                }
            }
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
        for(int a=0; a<depth; a++){
            if(visited[a][i]) return false;
            if(a != 0 && depth-a >= 0 && i-a >= 0 && visited[depth-a][i-a]) return false;
            if(a != 0 && depth+a < n && i+a < n && visited[depth+a][i+a]) return false;
            if(a != 0 && depth+a < n && i-a >= 0 && visited[depth+a][i-a]) return false;
            if(a != 0 && depth-a >= 0 && i+a < n && visited[depth-a][i+a]) return false;
        }
        return true;
    }
}