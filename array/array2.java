import java.util.*;
import java.util.stream.*;

// Check Array Formation Through Concatenation
// https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3589/

class LeetCode1{
    public static void main(String[] args){
        int[] arr = {91,4,64,78};
        int[][] pieces = {{78},{4,64},{91}};
        
        System.out.println(code(arr, pieces));
    }
    
    static boolean code(int[] arr, int[][] pieces){
        List<Integer> value = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int[] p : pieces){
            int preValue = -2;
            int nextValue = -2;
            for(int i=0; i<p.length; i++){
                nextValue = value.indexOf(p[i]);
                if(nextValue == -1) return false;
                else if(nextValue - preValue != 1 && i != 0){
                    return false;
                }
                preValue = nextValue;
            }
        }
        return true;
    }
}