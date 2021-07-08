package basic;

// 프로그래머스
// 숫자 문자열과 영단어
// https://programmers.co.kr/learn/courses/30/lessons/81301

public class basic26 {
    public static void main(String[] args){
        String s = "one4seveneight";

        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<nums.length; i++){
            s = s.replaceAll(nums[i], String.valueOf(i));
        }

        System.out.println(s);

    }
}
