import java.util.ArrayList;
import java.util.List;

public class Test2 {
    static int[][] direction = {{0,1}, {1,0}};
    static List<Integer> answer = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<puddles.length; i++){
            visited[puddles[i][0]-1][puddles[i][1]-1] = true;
        }

        dp(0, 0, visited, 0, m, n);
        
        System.out.println(answer.stream().filter(data->data==min).count());
    }

    static void dp(int y, int x, boolean[][] visited, int count, int m, int n){
        if(y >= n || x >= m) return;
        if(visited[y][x]) return;

        if(y == n-1 && x == m-1){
            answer.add(count);
            min = min < count ? min : count;
        }

        for(int i=0; i<direction.length; i++){
            dp(y+direction[i][0], x+direction[i][1], visited, count+1, m, n);
        }
    }
}
