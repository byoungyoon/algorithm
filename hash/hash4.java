package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// 프로그래머스
// 영어 끝말잇기

public class hash4 {
    public static void main(String[] args){
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        int count = 0;

        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                count = i+1;
                break;
            }

            int check = hs.size();
            hs.add(words[i]);
            
            if(check == hs.size()){
                count = i+1;
                break;
            }
        }
        int frist = 0;
        int second = 0;

        if(count != 0 ){
            frist = count%n==0?n:count%n;
            second = count%n == 0? count/n: count/n+1;
        }

        int[] answer = {frist, second};

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}
