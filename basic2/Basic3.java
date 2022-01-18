package basic2;

import java.util.ArrayList;
import java.util.List;

public class Basic3 {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

        Basic3 basic = new Basic3();
        System.out.println(basic.solution(arr));
    }

    private List<Integer> solution(int[] arr) {
        int num = -1;

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (num != arr[i]) {
                num = arr[i];
                answer.add(num);
            }
        }

        return answer;
    }
}
