package bruteforce;

// https://programmers.co.kr/learn/courses/30/lessons/60062

public class Brute4 {
    public static void main(String[] args) {
        int n = 200;
        int[] week = { 0, 100 };
        int[] dist = { 1, 1 };

        Brute4 test = new Brute4();
        System.out.println(test.solution(n, week, dist));
    }

    static int[][] weaks;
    static int answer = (int) 2e9;

    private int solution(int n, int[] weak, int[] dist) {
        int len = weak.length;
        weaks = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                weaks[i][j] = j + i >= len ? weak[(j + i) % len] + n : weak[j + i];
            }
        }

        boolean[] visited = new boolean[dist.length];
        permutation(dist, new int[dist.length], visited, 0, dist.length);

        if (answer >= dist.length + 1)
            return -1;

        return answer;
    }

    private void permutation(int[] dist, int[] value, boolean[] visited, int depth, int r) {
        if (depth == r) {
            onCompare(value);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            value[depth] = dist[i];
            permutation(dist, value, visited, depth + 1, r);
            visited[i] = false;
        }
    }

    private void onCompare(int[] value) {
        for (int i = 0; i < weaks.length; i++) {
            int temp = weaks[i][0];
            int index = 0;
            for (int j = 1; j < weaks.length; j++) {
                if (index >= value.length)
                    continue;
                if (weaks[i][j] <= value[index] + temp)
                    continue;
                temp = weaks[i][j];
                index++;

            }

            answer = answer < index + 1 ? answer : index + 1;
        }
    }

}
