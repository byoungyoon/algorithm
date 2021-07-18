package array;

// Leetcode
// Valid Anagram
// https://leetcode.com/problems/valid-anagram/

public class array17 {
    public static void main(String[] args){
        String s = "rat";
        String t = "car";

        array17 test = new array17();
        System.out.println(test.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] value = new int[26];

        for(char ch: s.toCharArray()){
            value[ch - 'a']++;
        }
        for(char ch: t.toCharArray()){
            if(value[ch - 'a'] == 0) return false;

            value[ch - 'a']--;
        }

        return true;
    }
}
