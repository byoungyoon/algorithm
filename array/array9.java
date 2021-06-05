package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스
// [1차] 다트 게임

public class array9 {
    public static void main(String[] args){
        String dartResult = "1D2S3T*";

        List<Character> special = new ArrayList<>();
        boolean check = false;
        for(int i=0; i<dartResult.length(); i++){
            if(check){
                if(dartResult.charAt(i) == '*'){
                     special.add('*');
                } else if(dartResult.charAt(i) == '#'){
                     special.add('#');
                } else{
                     special.add('0');
                }
                 check = false;
            }
            
           if(dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T'){
               check = true;
           }
        }

        if(special.size() != 3){
            special.add('0');
        }

        String[] normalNum = dartResult.replaceAll("[SDT]", " ").replaceAll("[*#]", "").split(" ");
        String[] normalPoint = dartResult.replaceAll("[*#0-9]", "").split("");

        int[] answer = new int[normalNum.length];
        for(int i=0; i<normalNum.length; i++){
            int pow = 0;
            switch(normalPoint[i]){
                case "S":
                    pow = 1;
                    break;
                case "D":
                    pow = 2;
                    break;
                default:
                    pow = 3;
                    break;
            }
            
            answer[i] = (int)Math.pow(Integer.parseInt(normalNum[i]), pow);
            
            char value = special.get(i);
            if(value != '0'){
                if(value == '*'){
                    if(i != 0){
                        answer[i-1] = answer[i-1] * 2;
                    } 
                    answer[i] = answer[i] * 2;
                } else{
                    answer[i] = answer[i] * -1;
                }
            }
        }
        
        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(answer).sum());
    }
}
