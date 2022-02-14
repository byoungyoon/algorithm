package array;

import java.util.Stack;
import java.util.StringTokenizer;

public class LinkedList1 {
    static Stack<Integer> stack = new Stack<>();
    static int size = 0;

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };

        LinkedList1 linkedList = new LinkedList1();
        System.out.println(linkedList.solution(n, k, cmd));
    }

    private String solution(int n, int k, String[] cmd) {
        size = n;
        for (String s : cmd) {
            StringTokenizer st = new StringTokenizer(s);
            k = action(st, k);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("O");
        }

        while (!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), 'X');
        }

        return sb.toString();
    }

    private int action(StringTokenizer st, int k) {
        switch (st.nextToken()) {
            case "U":
                k = k - Integer.parseInt(st.nextToken());
                break;
            case "D":
                k = k + Integer.parseInt(st.nextToken());
                break;
            case "C":
                stack.add(k);
                size--;
                if (size == k)
                    k--;
                break;
            case "Z":
                size++;
                if (stack.pop() <= k)
                    k++;
                break;
        }

        return k;
    }
}
