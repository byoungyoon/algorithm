package bruteforce;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42584

public class Brute3 {
    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };

        Brute3 brute = new Brute3();
        System.out.println(Arrays.toString(brute.solution(prices)));
    }

    public class Index {
        int num, index;

        public Index(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j])
                    break;
            }
            answer[i] = count;
        }

        return answer;
    }
}
