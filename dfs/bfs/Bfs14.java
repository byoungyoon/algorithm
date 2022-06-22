package dfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9019

public class Bfs14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Bfs14 test = new Bfs14();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(test.solution(start, end));
        }
    }

    private String solution(int start, int end) {
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(start, ""));

        boolean[] visited = new boolean[10001];
        while (!q.isEmpty()) {
            Num curr = q.poll();

            if (curr.num == end)
                return curr.command;

            if (visited[curr.num])
                continue;
            visited[curr.num] = true;

            q.add(new Num(actionD(curr.num), curr.command + "D"));
            q.add(new Num(actionS(curr.num), curr.command + "S"));
            q.add(new Num(actionL(curr.num), curr.command + "L"));
            q.add(new Num(actionR(curr.num), curr.command + "R"));
        }

        return "";
    }

    private int actionD(int num) {
        return (num * 2) % 10000;
    }

    private int actionS(int num) {
        return num == 0 ? 9999 : num - 1;
    }

    private int actionL(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    private int actionR(int num) {
        return (num % 10) * 1000 + num / 10;
    }

    class Num {
        int num;
        String command;

        public Num(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }
}
