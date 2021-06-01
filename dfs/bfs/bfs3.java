package dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스
// 게임 맵 최단거리

public class bfs3 {
    static int answer = 0;
    public static void main(String[] args){
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        Queue<Information> q = new LinkedList<>();

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        q.offer(new Information(0, 0, 1, visited));

        bfs(q, maps);

        System.out.println(answer);
    }

    static void bfs(Queue<Information> q, int[][] maps){
        if(q.isEmpty()){
            answer = -1;
            return;
        }
        Information information = q.poll();

        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=0; i<direction.length; i++){
            int nextY = information.getNextY() + direction[i][0];
            int nextX = information.getNextX() + direction[i][1];

            boolean[][] visited = information.getVisited();
            
            if(nextY < 0 || nextX < 0 || nextY >= maps.length || nextX >= maps[0].length) continue;
            if(visited[nextY][nextX]) continue;
            if(maps[nextY][nextX] == 0) continue;

            if(nextY == maps.length-1 && nextX == maps[0].length-1){
                answer = information.getCount() + 1;
                return;
            } 

            visited[nextY][nextX] = true;
            q.offer(new Information(nextY, nextX, information.getCount()+1, visited));
        }

        bfs(q, maps);
    }
}

class Information{
    private int nextY;
    private int nextX;
    private int count;
    private boolean[][] visited;

    public Information(int nextY, int nextX, int count, boolean[][] visited){
        this.nextY = nextY;
        this.nextX = nextX;
        this.count = count;
        this.visited = visited;
    }
    
    public int getNextY(){
        return nextY;
    }

    public int getNextX(){
        return nextX;
    }

    public int getCount(){
        return count;
    }

    public boolean[][] getVisited(){
        return visited;
    }
}
