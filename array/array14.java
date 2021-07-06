package array;

import java.util.Arrays;
import java.util.stream.Collectors;

// Leetcode
// Two sum
// https://leetcode.com/problems/two-sum/

public class array14 {
    public static void main(String[] args){
        int[] nums = {3,3};
        int target = 6;

        int[] sort = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            sort[i] = nums[i];
        }

        Arrays.sort(sort);

        int value = sort[0] + sort[sort.length-1];
        int start = 0;

        int end = sort.length-1;

        while(value != target){
            if(value < target){
                start = start + 1;
            } else{
                end = end - 1;
            }
            value = sort[start] + sort[end];
        }

        int[] answer = new int[2];
        boolean check = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == sort[start] && !check){
                answer[0] = i;
                check = true;
            } 
            
            if(nums[i] == sort[end]){
                answer[1] = i;
            }
        }

        Arrays.sort(answer);

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }
}
