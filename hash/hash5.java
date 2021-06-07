package hash;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 프로그래머스
// 문자열 내 마음대로 정렬하기

public class hash5 {
    public static void main(String[] args){
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        Arrays.sort(strings);

        HashMap<Integer, Character> hm = new HashMap<>();
        for(int i=0; i<strings.length; i++){
            hm.put(i, strings[i].charAt(n));
        }

        List<Integer> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, (a,b)->(hm.get(a)).compareTo(hm.get(b)));

        String[] answer = new String[strings.length];

        AtomicInteger index = new AtomicInteger();
        for(Integer i: list){
            answer[index.getAndIncrement()] = strings[i];
        }

        System.out.println(Arrays.asList(answer));
    }
}
