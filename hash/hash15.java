package hash;

import java.util.HashMap;
import java.util.Map;

// Leetcode
// Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/

public class hash15 {
    public static void main(String[] args){
        String[] strs = {"c","acc","ccc"};

        Map<String, Integer> hm = new HashMap<>();
        for(int i=0; i<strs[0].length(); i++){
            String value = strs[0].substring(0, i+1);
            hm.put(value, 1);
        }

        for(int i=1; i<strs.length; i++){
            for(String key: hm.keySet()){
                if(hm.get(key) == i){
                    if(strs[i].startsWith(key)){
                        hm.put(key, i+1);
                    }
                }
            }
        }

        String answer = "";
        for(String key: hm.keySet()){
            if(hm.get(key) != strs.length) continue;

            if(answer.length() < key.length()) answer = key;
        }

        System.out.println(answer);
    }
}
