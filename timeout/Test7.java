package timeout;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Test7 {
    public static void main(String[] args){
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = new int[queries.length];

        Map<String, Integer> hm = new HashMap<>(); 
        String wildCard = "?";
        for(String word: words){
            for(int i=0; i<word.length()-1; i++){
                String forward = wildCard.repeat(i+1) + word.substring(i+1);
                String reverse = word.substring(0, word.length()-i-1) + wildCard.repeat(i+1);
                hm.put(forward, hm.getOrDefault(forward, 0) + 1);
                hm.put(reverse, hm.getOrDefault(reverse, 0) + 1);
            }
            hm.put(wildCard.repeat(word.length()), hm.getOrDefault(wildCard.repeat(word.length()), 0) + 1);

            if(hm.size() > 10000){
                for(int i=0; i<queries.length; i++){
                    answer[i] += hm.getOrDefault(queries[i], 0);
                }
                hm.clear();
            }
        }

        for(int i=0; i<queries.length; i++){
            answer[i] += hm.getOrDefault(queries[i], 0);
        }

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}
