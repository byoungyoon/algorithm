package rescue;

import java.util.Arrays;

public class Rescue25 {
    public static void main(String[] args) {
        long k = 2;
        int[] food_times = { 3 };

        Rescue25 test = new Rescue25();
        System.out.println(test.solution(food_times, k));
    }

    private int solution(int[] food_times, long k) {
        int[] clone = food_times.clone();
        Arrays.sort(clone);

        long size = clone.length;
        long repeat = 0;
        for (int i : clone) {
            long value = k - ((i - repeat) * size);
            if (value < 0) {
                break;
            }
            k = value;
            repeat = i;
            size--;
        }

        if (size == 0)
            return -1;

        if (k >= size)
            k = k % size;

        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] <= repeat)
                continue;
            if (k == 0)
                return i + 1;
            k--;
        }

        return 1;
    }
}
