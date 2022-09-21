package dfs.bfs;

// https://school.programmers.co.kr/learn/courses/30/lessons/43162#qna

public class Dfs21 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        Dfs21 test = new Dfs21();
        System.out.println(test.solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            dfs(computers, visited, i);
            answer++;
        }

        return answer;
    }

    public void dfs(int[][] computers, boolean[] visited, int n) {
        for (int i = 0; i < computers.length; i++) {
            if (i == n || computers[i][n] == 0 || visited[i])
                continue;
            visited[i] = true;
            dfs(computers, visited, i);
        }
    }
}
