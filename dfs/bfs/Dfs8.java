package dfs.bfs;

// https://programmers.co.kr/learn/courses/30/lessons/42860

public class Dfs8 {
    public static void main(String[] args) {
        String name = "BAAAAABBB";

        Dfs8 dfs = new Dfs8();
        System.out.println(dfs.solution(name));
    }

    static int answer = Integer.MAX_VALUE;
    static int[] direction = { 1, -1 };

    public int solution(String name) {
        boolean[][] visited = new boolean[name.length()][name.length()];
        String str = "";
        for (int i = 0; i < name.length(); i++) {
            str += "A";
        }

        dfs(name, 0, 0, str, visited);
        return answer;
    }

    public void dfs(String name, int index, int depth, String str, boolean[][] visited) {
        if (name.equals(str)) {
            answer = answer < depth ? answer : depth;
            return;
        }

        boolean check = false;
        if (name.charAt(index) == str.charAt(index)) {
            check = true;
        }

        if (!check) {
            dfs(name, index, depth + onUpDown(name.charAt(index), str.charAt(index)), repStr(name, str, index),
                    visited);
        } else {
            for (int d : direction) {
                int nextIndex = index + d;
                if (nextIndex < 0)
                    nextIndex = name.length() - 1;
                if (nextIndex >= name.length())
                    nextIndex = 0;

                if (visited[index][nextIndex])
                    continue;
                visited[index][nextIndex] = true;
                dfs(name, nextIndex, depth + 1, str, visited);
                visited[index][nextIndex] = false;
            }
        }
    }

    public String repStr(String name, String str, int index) {
        return str.substring(0, index) + name.charAt(index) + str.substring(index + 1);
    }

    public int onUpDown(char index, char str) {
        int start = (int) str;
        int end = (int) index;

        int value = start - 65 + 1;
        return end - start > value + 90 - end ? value + 90 - end : end - start;
    }
}
