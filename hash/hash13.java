package hash;

import java.util.HashSet;
import java.util.Set;

// Leetcode
// Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class hash13 {
    public static void main(String[] args){
        String s = " ";

        int answer = 0;

        Set<Character> hs = new HashSet<>();
        int index = 0;
        int remove = 0;
    
        while(index != s.length()){
            int size = hs.size();
            hs.add(s.charAt(index));

            if(hs.size() != size){
                index = index + 1;
            } else{
                hs.remove(s.charAt(remove));
                remove = remove + 1;
            }

            answer = answer > hs.size() ? answer : hs.size();
        }

        System.out.println(answer);
    }
}
