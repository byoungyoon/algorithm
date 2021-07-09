package hash;

import java.util.HashMap;
import java.util.Map;

// Leetcode
// Custom Sort String

public class hash14 {
    public static void main(String[] args){
        String order = "cba";
        String str = "abcd";

        Map<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            hm.put(order.charAt(i), i);
        }

        String[] value = new String[order.length()+1];
        for(int i=0; i<str.length(); i++){
            if(hm.containsKey(str.charAt(i))){
                value[hm.get(str.charAt(i))] += str.charAt(i);
            } else{
                value[value.length-1] += str.charAt(i);
            }
        }

        String answer = "";
        for(int i=0; i<value.length; i++){
            if(value[i] != null){
                answer += value[i].substring(4);
            }
        }

        System.out.println(answer);

        
    }
}
