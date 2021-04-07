package hash;

import java.util.HashMap;
import java.util.Map;

// leetcode
// https://leetcode.com/submissions/detail/521708898/?from=explore&item_id=3811

public class hash12 {
    public static void main(String[] args){
        String s = "paper";
        String t = "title";

        System.out.println(contain(s, t));
    }

    static boolean contain(String s, String t){
        Map<Character, Integer> hm = new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!hm.containsKey(s.charAt(i)) && !hm2.containsKey(t.charAt(i))){
                hm.put(s.charAt(i), i);
                hm2.put(t.charAt(i), i);
            } else if(hm.containsKey(s.charAt(i)) && hm2.containsKey(t.charAt(i))){
                if(hm.get(s.charAt(i)) != hm2.get(t.charAt(i))) return false;
            } else{
                return false;
            }
        }

        return true;
    }
}
