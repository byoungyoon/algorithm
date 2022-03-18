package basic2;

// https://programmers.co.kr/learn/courses/30/lessons/12921

public class Basic10 {
    public static void main(String[] args) {
        int n = 10;

        Basic10 basic = new Basic10();
        System.out.println(basic.solution(n));
    }

    public int solution(int n) {
        return prime(n);
    }

    public int prime(int num) {
        boolean[] visited = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            if (visited[i])
                continue;
            for (int j = i * 2; j <= num; j += i) {
                visited[j] = true;
            }
        }

        int result = 1;
        for (int i = 3; i < visited.length; i++) {
            if (!visited[i])
                result++;
        }

        return result;
    }

}
