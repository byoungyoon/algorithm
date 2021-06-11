package timeout;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test3 {
    static int INF = 99999;
    public static void main(String[] args){
        int n = 11;
        int[][] edge = {{1,2}};

        int[] value = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(value, INF);
        value[0] = 0;

        for(int i=0; i<n; i++){
            int index = selectCurrent(value, visited);
    
            dijkstra(edge, value, index);
        }

        System.out.println(Arrays.stream(value).boxed().collect(Collectors.toList()));
        Arrays.sort(value);
        System.out.println(Arrays.stream(value).filter(data-> data==value[value.length-1]).count());
        
    }

    static int selectCurrent(int[] value, boolean[] visited){
        int current = INF;
        int index = 0;

        for(int i=0; i<value.length; i++){
            if(visited[i]) continue;
            if(current > value[i]){
                current = value[i];
                index = i+1;
                visited[i] = true;
            }    
        }

        return index;
    }

    static void dijkstra(int[][] edge, int[] value, int index){
        for(int i=0; i<edge.length; i++){
            if(edge[i][0] == index){
                if(value[edge[i][1]-1] > value[edge[i][0]-1] + 1){
                    value[edge[i][1]-1] = value[edge[i][0]-1] + 1;
                } 
            } else if(edge[i][1] == index){
                if(value[edge[i][0]-1] > value[edge[i][1]-1] + 1){
                    value[edge[i][0]-1] = value[edge[i][1]-1] + 1;
                } 
            }
        }
    }
}
