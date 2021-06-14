package quest;

// 프로그래머스
// 징검다리 건너기
// https://programmers.co.kr/learn/courses/30/lessons/64062

public class quest2 {
    public static void main(String[] args){
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        
        int start = 1;
        int end = 200000000;
        for(int stone: stones){
            start = start < stone ? start : stone;
            end = end < stone ? stone : end;
        }

        int answer = 0;

        while(start<=end){
            int mid = (start+end)/2;

            if(judgment(stones, mid, k)){
                start = mid+1;
                answer = answer > mid ? answer : mid;
            } else{
                end = mid-1;
            }
        }

        System.out.println(answer);
    }

    static boolean judgment(int[] stones, int mid, int k){
        int count = 0;
        for(int stone: stones){
            if(stone-mid < 0){
                count = count + 1;
            } else{
                count = 0;
            }
            if(count == k){
                return false;
            }
        }

        return true;
    }
}
