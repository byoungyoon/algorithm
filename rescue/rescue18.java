package rescue;

import java.util.HashMap;
import java.util.Map;

// Leetcode
// Roman to Integer
// https://leetcode.com/problems/roman-to-integer/

public class rescue18 {
    public static void main(String[] args){
        String s = "MDCCCLXXXIV";

        Map<Character, Integer> hm = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int answer = 0;

        boolean place1 = false;
        boolean place2 = false;
        boolean place3 = false;
        for(int i=0; i<s.length(); i++){
            char value = s.charAt(i);
            int count = hm.get(value);
            answer += count;

            switch(value){
                case 'I':
                    place1 = true;
                    place2 = false;
                    place3 = false;
                    break;
                case 'V':
                    if(place1) answer -= 2;
                    place1 = false;
                    place2 = false;
                    place3 = false;
                    break;
                case 'X':
                    if(place1) answer -= 2;
                    place1 = false;
                    place2 = true;
                    place3 = false;
                    break;
                case 'L':
                    if(place2) answer -= 20;
                    place1 = false;
                    place2 = false;
                    place3 = false;
                    break;
                case 'C':
                    if(place2) answer -= 20;
                    place1 = false;
                    place2 = false;
                    place3 = true;
                    break;
                case 'D':
                    if(place3) answer -= 200;
                    place1 = false;
                    place2 = false;
                    place3 = false;
                    break;
                case 'M':
                    if(place3) answer -= 200;
                    place3 = false;
                    place1 = false;
                    place2 = false;
                    break;
            }
        }

        System.out.println(answer);
    }
}
