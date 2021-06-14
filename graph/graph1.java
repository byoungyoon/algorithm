package graph;

import java.util.Arrays;

// 프로그래머스
// 배달

public class graph1 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args){
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int N = 5;
        int K = 3;

        int[] route = new int[N];
        Arrays.fill(route, INF);
        boolean[] visited = new boolean[N];

        route[0] = 0;
        visited[0] = true;
        int start = 1;

        for(int i=0; i<N; i++){
            dijkstra(road, route, start);
            start = minK(route, visited);
        }

        System.out.println(Arrays.stream(route).filter(data-> data<=K).count());
    }

    static int minK(int[] route, boolean[] visited){
        int index = 0;
        int num = INF;
        
        for(int i=0; i<route.length; i++){
            if(visited[i]) continue;

            if(route[i] < num){
                num = route[i];
                index = i;
            }
        }

        visited[index] = true;
        return index+1;
    }

    static void dijkstra(int[][] road, int[] route, int start){
        for(int i=0; i<road.length; i++){
            if(road[i][0] == start){
                if(route[road[i][1]-1] > road[i][2] + route[road[i][0]-1]){
                    route[road[i][1]-1] = road[i][2] + route[road[i][0]-1];
                }
            } else if(road[i][1] == start){
                if(route[road[i][0]-1] > road[i][2] + route[road[i][1]-1]){
                    route[road[i][0]-1] = road[i][2] + route[road[i][1]-1];
                }
            }
        }
    }
}
