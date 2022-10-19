package kakao2021;

import java.util.Stack;
import java.util.StringTokenizer;

// https://school.programmers.co.kr/learn/courses/30/lessons/81303

public class Kakao3 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };

        Kakao3 test = new Kakao3();
        System.out.println(test.solution(n, k, cmd));
    }

    Stack<Integer> stack;

    public String solution(int n, int k, String[] cmd) {
        stack = new Stack<>();

        int len = n;
        for (String str : cmd) {
            k = onAction(str, len, k);
            len = n - stack.size();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("O");
        }

        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }

        return sb.toString();
    }

    public int onAction(String str, int len, int k) {
        StringTokenizer st = new StringTokenizer(str);

        switch (st.nextToken()) {
            case "U":
                k -= Integer.parseInt(st.nextToken());
                break;
            case "D":
                k += Integer.parseInt(st.nextToken());
                break;
            case "C":
                stack.push(k);

                if (k == len - 1)
                    k--;
                break;
            case "Z":
                if (stack.pop() <= k)
                    k++;
                break;
            default:
                break;
        }

        return k;
    }

}
