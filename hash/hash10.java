package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 프로그래머스
// 테스트

public class hash10 {
    public static void main(String[] args){
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};

        Map<Integer, Integer> hmX = new HashMap<>();
        Map<Integer, Integer> hmY = new HashMap<>();

        for(int i=0; i<v.length; i++){
            hmX.put(v[i][0], hmX.getOrDefault(v[i][0], 0)+1);
            hmY.put(v[i][1], hmY.getOrDefault(v[i][1], 0)+1);
        }

        int[] answer = new int[2];

        for(Integer key: hmX.keySet()){
            if(hmX.get(key) == 1) answer[0] = key;
        }

        for(Integer key: hmY.keySet()){
            if(hmY.get(key) == 1) answer[1] = key;
        }

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}
