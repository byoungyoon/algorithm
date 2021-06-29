package hash;

// 프로그래머스
// 가사 검색 (hashmap)
// https://programmers.co.kr/learn/courses/30/lessons/60060

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class hash10 {
    public static void main(String[] args){
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = new int[queries.length];

        Map<String, Integer> hm = new HashMap<>(); 
        String wildCard = "?";
        for(String word: words){
            for(int i=0; i<word.length()-1; i++){
                String forward = "";
                String reverse = "";
                String addWord = "";
                for(int j=0; j<i+1; j++){
                    addWord += wildCard;
                }
                for(int j=addWord.length(); j<word.length(); j++){
                    forward += word.charAt(j);
                    reverse += word.charAt(j-addWord.length());
                }
                hm.put(addWord + forward, hm.getOrDefault(addWord + forward, 0) + 1);
                hm.put(reverse + addWord, hm.getOrDefault(reverse + addWord, 0) + 1);
            }
            hm.put(wildCard.repeat(word.length()), hm.getOrDefault(wildCard.repeat(word.length()), 0) + 1);
        }

        for(int i=0; i<queries.length; i++){
            if(hm.get(queries[i]) == null) continue;
            answer[i] += hm.get(queries[i]);
        }

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}
