package backtracking;

import java.util.*;

// 프로그래머스
// 합승 택시 요금

public class backtracking4 {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args){
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(solution(n, s, a, b, fares));
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        int[] sArray = dijkstra(s, n, fares);
        int[] aArray = dijkstra(a, n, fares);
        int[] bArray = dijkstra(b, n, fares);
        
        for(int i=1; i<sArray.length; i++){
            if(answer > sArray[i] + aArray[i] + bArray[i]){
                answer = sArray[i] + aArray[i] + bArray[i];
            }
        }
        return answer;
    }
    
    public static int[] dijkstra(int start, int n, int[][] fares){
        boolean[] checkArray = new boolean[n+1];
        int[] array = new int[n+1];
        Arrays.fill(array, INF);
        array[start] = 0;
        
        for(int j=0; j<n; j++){
            int index = nextIndex(array, checkArray);
            for(int i=0; i<fares.length; i++){
                if(fares[i][0] == index){
                    if(array[fares[i][1]] > array[fares[i][0]]+fares[i][2]){
                        array[fares[i][1]] = array[fares[i][0]]+fares[i][2];
                    }
                } else if(fares[i][1] == index){
                    if(array[fares[i][0]] > array[fares[i][1]]+fares[i][2]){
                        array[fares[i][0]] = array[fares[i][1]]+fares[i][2];
                    }
                }
            }
        }
        
        return array;
    }
    
    public static int nextIndex(int[] array, boolean[] checkArray){
        int min = INF;
        int index = 0;
        for(int i=0; i<array.length; i++){
            if(checkArray[i] == true){
                continue;
            }
            if(min > array[i]){
                min = array[i];
                index = i;
            }
        }
        checkArray[index] = true;
        
        return index;
    }
}
