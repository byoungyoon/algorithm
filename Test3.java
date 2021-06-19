import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    static boolean[][] visited;
    static int direction[][] = {{0,1}, {1,0}, {-1,-1}};
    public static void main(String[] args){
        int n = 4;
        
        int[][] value = new int[n][n];
        visited = new boolean[n][n];
        
        int count = 1;
        value[0][0] = count;

        dp(0, 0, 0, count, value);
    }

    static void dp(int y, int x, int checkout, int count, int[][] value){
        int checkX = direction[checkout][0] + x;
        int checkY = direction[checkout][1] + y;

        if(checkX >= value.length || checkY >= value.length || visited[checkY][checkX]){
            checkout = checkout + 1;
            if(checkout >= 3){
                checkout = 0;
            }
        }

        int nextX = direction[checkout][0] + x;
        int nextY = direction[checkout][1] + y;

        System.out.println(nextY + " " + nextX + " : " + count);

        value[nextY][nextX] = count;
        visited[y][x] = true;
        dp(nextY, nextX, checkout, count+1, value);
    }
}
