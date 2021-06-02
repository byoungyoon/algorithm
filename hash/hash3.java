package hash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 프로그래머스
// 실패율

public class hash3 {
    public static void main(String[] args){
        int N = 4;
        int[] stages = {4,4,4,4};

        Arrays.sort(stages);
        Long count = Long.valueOf(stages[0]);
        Long index = 0L;

        Long size = Long.valueOf(stages.length);
        HashMap<Long, Double> hm = new HashMap<>();

        for(int i=1; i<=N; i++){
            hm.put(Long.valueOf(i), 0.0);
        }

        for(int i: stages){
            if(count != i){
                hm.put(count, index / (double)size);
                count = Long.valueOf(i);
                size = size - index;
                index = 0L;
            } 
            index = index + 1;
        }
        hm.put(count, 1.0);

        List<Long> answer = new ArrayList<>(hm.keySet());
        if(count > N){
            answer.remove(answer.size()-1);
        }

        Collections.sort(answer, (a,b)-> (hm.get(b)).compareTo(hm.get(a)));

        for(Long key: answer){
            System.out.println(key + " " + hm.get(key));
        }
    }
}
