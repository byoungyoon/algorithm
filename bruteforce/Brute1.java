package bruteforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Brute1 {
    static int answer = 0;
    List<List<Integer>> selectByVisited = new ArrayList<>();

    public static void main(String[] args) {
        String[][] relation = { { "a", "1", "aaa", "c", "ng" }, { "b", "1", "bbb", "c", "g" },
                { "c", "1", "aaa", "d", "ng" }, { "d", "2", "bbb", "d", "ng" } };

        Brute1 brute = new Brute1();
        System.out.println(brute.solution(relation));
    }

    private int solution(String[][] relation) {
        boolean[] visited = new boolean[relation[0].length];
        boolean[] select = new boolean[relation[0].length];

        answer = 0;

        for (int i = 1; i <= visited.length; i++) {
            backtracking(visited, select, relation, 0, relation[0].length, i);
        }

        return answer;
    }

    private void backtracking(boolean[] visited, boolean[] select, String[][] relation, int depth, int n, int r) {
        if (r == 0) {
            List<Integer> counting = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    continue;

                counting.add(i);
            }

            candidate(relation, counting);

            return;
        }

        if (depth == n)
            return;

        visited[depth] = true;
        backtracking(visited, select, relation, depth + 1, n, r - 1);
        visited[depth] = false;
        backtracking(visited, select, relation, depth + 1, n, r);
    }

    private void candidate(String[][] relation, List<Integer> counting) {
        Set<String> check = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            String key = "";
            for (Integer in : counting) {
                key = key + relation[i][in] + " ";
            }
            check.add(key);
        }

        if (check.size() != relation.length)
            return;

        for (List<Integer> list : selectByVisited) {
            int num = 0;
            for (Integer i : counting) {
                if (list.indexOf(i) != -1)
                    num++;
            }

            if (num == list.size())
                return;
        }

        selectByVisited.add(counting);
        answer++;
    }
}