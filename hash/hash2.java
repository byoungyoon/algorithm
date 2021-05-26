package hash;

import java.util.HashSet;

// 프로그래머스
// 폰켓몬

public class hash2 {
    public static void main(String[] args){
        int[] nums = {3,3,3,2,2,2};

        HashSet<Integer> hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }

        System.out.println(nums.length/2 > hs.size()? hs.size(): nums.length/2);
    }
}
