package array;
import java.util.ArrayList;
import java.util.List;

// Leetcode
// Median of Two Sorted Arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class array15 {
    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        int index1 = 0;
        int index2 = 0;

        List<Integer> list = new ArrayList<>();
        while(index1 != nums1.length || index2 != nums2.length){
            if(index1 >= nums1.length){
                list.add(nums2[index2]);
                index2 = index2 + 1;
                continue;
            }
            if(index2 >= nums2.length){
                list.add(nums1[index1]);
                index1 = index1 + 1;
                continue;
            }

            if(nums1[index1] < nums2[index2]){
                list.add(nums1[index1]);
                index1 = index1 + 1;
            } else{
                list.add(nums2[index2]);
                index2 = index2 + 1;
            }

        }
        
        double answer = 0;
        int size = list.size() / 2;
        if(list.size() % 2 == 0){
            answer = (list.get(size) + list.get(size-1)) / (double)2;
        } else{
            answer = (double)list.get(size);
        }

        System.out.println(answer);
    }
}
