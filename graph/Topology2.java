package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Topology2 {
    static Map<Integer, List<Integer>> hm;
    static int[] build;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hm = new HashMap<>();
        count = new int[N + 1];
        build = new int[N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            build[i + 1] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == -1)
                    continue;

                hm.computeIfAbsent(temp, data -> new ArrayList<>()).add(i + 1);
                count[i + 1]++;
            }
        }

        Topology2 test = new Topology2();
        int[] answer = test.solution(N);

        for (int i = 1; i < answer.length; i++)
            System.out.println(answer[i]);
    }

    private int[] solution(int N) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0)
                q.add(i);
        }

        int[] max = new int[N + 1];
        while (!q.isEmpty()) {
            int curr = q.poll();

            if (hm.containsKey(curr)) {
                for (int i : hm.get(curr)) {
                    count[i]--;
                    max[i] = Math.max(max[i], build[curr]);

                    if (count[i] == 0) {
                        q.add(i);
                        build[i] += max[i];
                    }
                }
            }
        }

        return build;
    }
}
