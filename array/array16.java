package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Leetcode
// 3Sum
// https://leetcode.com/problems/3sum/

public class array16 {
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};

        Arrays.sort(nums);

        Set<List<Integer>> answer = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            int current = i;
            int front = i+1;
            int back = nums.length - 1;
            while(front < back){
                int sum = nums[current] + nums[front] + nums[back];

                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[current]);
                    list.add(nums[front]);
                    list.add(nums[back]);
                    answer.add(list);

                    front = front + 1;
                    back = back - 1;
                    continue;
                } else if(sum < 0){
                    front = front + 1;
                } else{
                    back = back - 1;
                }
            }
        }

        System.out.println(new ArrayList<>(answer));
    }
}
