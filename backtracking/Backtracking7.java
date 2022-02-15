package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Backtracking7 {
    static List<String[]> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "*rodo", "*rodo", "******" };

        Backtracking7 backtracking = new Backtracking7();
        System.out.println(backtracking.solution(user_id, banned_id));
    }

    private int solution(String[] user_id, String[] banned_id) {
        String[] output = new String[banned_id.length];
        boolean[] visited = new boolean[user_id.length];

        backtracking(user_id, banned_id, visited, output, user_id.length, banned_id.length, 0);

        return answer;
    }

    private void backtracking(String[] user_id, String[] banned_id, boolean[] visited, String[] output, int n, int r,
            int depth) {
        if (depth == r) {
            if (edit(output, banned_id)) {
                String[] clone = output.clone();
                for (String[] select : list) {
                    if (!compare(select, clone))
                        return;
                }

                list.add(clone);
                answer++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            output[depth] = user_id[i];
            backtracking(user_id, banned_id, visited, output, n, r, depth + 1);
            visited[i] = false;
        }
    }

    private boolean compare(String[] select, String[] clone) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < select.length; i++) {
            set.add(select[i]);
            set.add(clone[i]);
        }

        return select.length != set.size();
    }

    private boolean edit(String[] output, String[] banned_id) {
        for (int i = 0; i < output.length; i++) {
            if (output[i].length() != banned_id[i].length())
                return false;

            for (int j = 0; j < output[i].length(); j++) {
                if (banned_id[i].charAt(j) == '*')
                    continue;

                if (output[i].charAt(j) != banned_id[i].charAt(j))
                    return false;
            }
        }

        return true;
    }
}
