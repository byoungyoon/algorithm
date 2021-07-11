package basic;

import java.util.HashMap;
import java.util.Map;

// Leetcode
// Find Peak Element

public class basic28 {
    public static void main(String[] args){
        int[] nums = {1,2,3,1};

        Map<Integer, Integer> hm = new HashMap<>();
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], i);
            }

            max = max > nums[i] ? max : nums[i];
        }

        System.out.println(hm.get(max));
    }
}
