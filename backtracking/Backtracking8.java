package backtracking;

// https://programmers.co.kr/learn/courses/30/lessons/87946

public class Backtracking8 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

        Backtracking8 backtracking = new Backtracking8();
        System.out.println(backtracking.solution(k, dungeons));
    }

    static int tempK = 0;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int[] value = new int[dungeons.length];

        permutation(dungeons, k, value, visited, 0, dungeons.length);
        return answer;
    }

    public void permutation(int[][] dungeons, int k, int[] value, boolean[] visited, int depth, int n) {
        if (depth == n) {
            tempK = k;
            int sum = 0;
            for (int i : value) {
                if (tempK < dungeons[i][0])
                    continue;
                tempK -= dungeons[i][1];
                sum++;
            }
            answer = answer > sum ? answer : sum;
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            value[depth] = i;
            permutation(dungeons, k, value, visited, depth + 1, n);
            value[depth] = 0;
            visited[i] = false;
        }
    }
}
