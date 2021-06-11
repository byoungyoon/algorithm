import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    static int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static int[][] maps;
    static Queue<Location> q = new LinkedList<>();
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        // 직선 100, 코너 500

        maps = new int[board.length][board.length];
        q.offer(new Location(0,0,-1,0));

        bfs(board);

        System.out.println(maps[board.length-1][board.length-1]);
    }  
    
    static void bfs(int[][] board){
        if(q.isEmpty()) return;

        Location location = q.poll();
        for(int i=0; i<direction.length; i++){
            int nextY = location.getY() + direction[i][0];
            int nextX = location.getX() + direction[i][1];

            if(nextY < 0 || nextX < 0 || nextY >= board.length || nextX >= board.length) continue;
            if(board[nextY][nextX] == 1) continue;
            
            int vector = location.getVector();
            int cost = location.getCost();
            if(vector == -1 || vector == i){
                cost = cost + 100;
            } else{
                cost = cost + 600;
            }
            
            if(maps[nextY][nextX] == 0){
                maps[nextY][nextX] = cost;
            } else{
                if(maps[nextY][nextX] < cost) continue;
                maps[nextY][nextX] = cost;
            }

            q.offer(new Location(nextY, nextX, i, cost));
            bfs(board);
        }
    }   

}

class Location{
    private int y;
    private int x;
    private int vector;
    private int cost;

    public Location(int y, int x, int vector, int cost){
        this.y = y;
        this.x = x;
        this.vector = vector;
        this.cost = cost;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public int getVector(){
        return vector;
    }

    public int getCost(){
        return cost;
    }
}