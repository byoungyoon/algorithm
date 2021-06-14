package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

// 프로그래머스
// 보석 쇼핑

public class hash8{
    public static void main(String[] args){
        String[] gems = {"A", "B", "A", "A", "A", "C", "A", "B"};

        HashSet<String> hs = new HashSet<>();
        for(String gem: gems){
            hs.add(gem);
        }

        List<Index> index = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        for(int i=0; i<gems.length; i++){
            hm.put(gems[i], i);

            if(hm.size() == hs.size()){
                for(String s: hm.keySet()){
                    list.add(hm.get(s));
                }

                Collections.sort(list);

                int start = list.get(0);
                int end = list.get(list.size()-1);

                hm.remove(gems[list.get(0)]);
                list.remove(0);

                while(hm.size() == hs.size()){
                    start = list.get(0);
                    end = list.get(list.size()-1);

                    hm.remove(gems[list.get(0)]);
                    list.remove(0);
                }

                index.add(new Index(start, end, end-start));
                
                list.clear();
            }
        }

        index.sort(Comparator.comparing(Index::getDif).thenComparing(Index::getStart));

        int[] answer = {index.get(0).getStart()+1, index.get(0).getEnd()+1};

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}

class Index{
    private int start;
    private int end;
    private int dif;

    public Index(int start, int end, int dif){
        this.start = start;
        this.end = end;
        this.dif = dif;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public int getDif(){
        return dif;
    }
}