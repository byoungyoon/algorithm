import java.util.Arrays;
import java.util.Collections;

public class Test4 {
    public static void main(String[] args){
        int[] prices = {32000, 18000, 42500};
        int[] discounts = {50, 20, 65};

        Arrays.sort(prices);
        Arrays.sort(discounts);

        int answer = 0;

        for(int i=0; i<discounts.length; i++){
            int count = 100 - discounts[discounts.length-1-i];
            answer += prices[prices.length-1-i] / 100 * count;
        }

        int size = prices.length - discounts.length;
        for(int i=0; i<size; i++){
            answer += prices[i];
        }

        System.out.println(answer);
    }
}
