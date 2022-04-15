package rescue2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/68936

public class Rescue2 {
    public static void main(String[] args) {
        int arr[][] = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

        Rescue2 test = new Rescue2();
        System.out.println(Arrays.toString(test.solution(arr)));
    }

    static int[] answer = { 0, 0 };

    public int[] solution(int[][] arr) {
        compression(arr, arr.length, 0, 0);

        return answer;
    }

    public void compression(int[][] arr, int width, int Y, int X) {
        int base = arr[Y][X];
        if (width == 1) {
            answer[base]++;
            return;
        }

        for (int i = Y; i < Y + width; i++) {
            for (int j = X; j < X + width; j++) {
                if (base != arr[i][j]) {
                    compression(arr, width / 2, Y, X);
                    compression(arr, width / 2, Y + width / 2, X);
                    compression(arr, width / 2, Y, X + width / 2);
                    compression(arr, width / 2, Y + width / 2, X + width / 2);
                    return;
                }
            }
        }
        answer[base]++;
    }
}
