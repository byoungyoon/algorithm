package hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

// 프로그래머스
// 베스트 앨범
// https://programmers.co.kr/learn/courses/30/lessons/42579

public class hash9 {
    public static void main(String[] args){
        String[] genres = {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};
        int[] plays = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        
        HashMap<String, List<Integer>> hm = new HashMap<>();
        HashMap<String, Integer> size = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            hm.computeIfAbsent(genres[i], data->new ArrayList<>()).add(i);
            size.put(genres[i], size.getOrDefault(genres[i], 0)+plays[i]);
        }

        List<String> list = new ArrayList<>(size.keySet());
        list.sort(Comparator.comparing(data-> size.get(data)).reversed());

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            List<Integer> value = hm.get(list.get(i));
            List<Index9> indexValue = new ArrayList<>();
            for(int j=0; j<value.size(); j++){
                indexValue.add(new Index9(plays[value.get(j)], value.get(j)));
            }
            indexValue.sort(Comparator.comparing(Index9::getPlay).reversed().thenComparing(Index9::getIndex));

            int count = 2 > value.size() ? value.size() : 2; 
            for(int j=0; j<count; j++){
                answer.add(indexValue.get(j).getIndex());
            }
        }

        System.out.println(answer);
        
    }   
}

class Index9{
    private int play;
    private int index;

    public Index9(int play, int index){
        this.play = play;
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public int getPlay(){
        return play;
    }
}