package hash;

import java.util.HashMap;
import java.util.Map;

// Leetcode
// Valid Anagram
// https://leetcode.com/problems/valid-anagram/

public class hash16 {
    public static void main(String[] args){
        String s = "a";
        String t = "ab";

        hash16 test = new hash16();
        System.out.println(test.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        Map<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0)-1);
        }

        System.out.println(hm);

        for(Character key: hm.keySet()){
            if(hm.get(key) != 0){
                return false;
            }
        }

        return true;
    }
}
