package heap;

import java.util.PriorityQueue;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42746

public class Heap6 {
    public static void main(String[] args) {
        int[] numbers = { 37, 373 };

        Heap6 heap = new Heap6();
        System.out.println(heap.solution(numbers));
    }

    public class Number implements Comparable<Number> {
        int num;

        public Number(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            String[] value = String.valueOf(this.num).split("");
            String[] oValue = String.valueOf(o.num).split("");

            int len = value.length > oValue.length ? value.length : oValue.length;
            for (int i = 0; i < len + 1; i++) {
                int index = i - (i / value.length) * value.length;
                int oIndex = i - (i / oValue.length) * oValue.length;
                if (value[index].equals(oValue[oIndex]))
                    continue;

                return Integer.parseInt(oValue[oIndex]) - Integer.parseInt(value[index]);
            }

            return 0;
        }
    }

    public String solution(int[] numbers) {
        Queue<Number> q = new PriorityQueue<>();
        for (int n : numbers) {
            q.add(new Number(n));
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll().num);
        }

        String answer = sb.toString().replaceFirst("^0*", "");
        if (answer.equals(""))
            answer += 0;

        return answer;
    }
}
