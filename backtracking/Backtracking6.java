package backtracking;

import java.util.HashMap;
import java.util.Map;

public class Backtracking6 {
    Map<Character, Integer> map = new HashMap<>();
    static int answer = 0;

    public static void main(String[] args) {
        int n = 2;
        String[] data = { "M~C<2", "C~M>1" };

        Backtracking6 backtracking = new Backtracking6();
        System.out.println(backtracking.solution(n, data));
    }

    private int solution(int n, String[] data) {
        Character[] member = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
        boolean[] visited = new boolean[member.length];

        answer = 0;
        map.clear();

        Character[] output = new Character[member.length];
        backtracking(member, output, data, visited, 0, output.length);

        return answer;
    }

    private void backtracking(Character[] member, Character[] output, String[] data, boolean[] visited, int depth,
            int r) {
        if (depth == r) {
            for (int i = 0; i < member.length; i++) {
                map.put(output[i], i);
            }

            discrimination(data);
            return;
        }

        for (int i = 0; i < member.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            output[depth] = member[i];
            backtracking(member, output, data, visited, depth + 1, r);
            visited[i] = false;
        }
    }

    private void discrimination(String[] data) {
        for (String s : data) {
            int value = map.get(s.charAt(0)) - map.get(s.charAt(2));
            int result = Character.getNumericValue(s.charAt(4)) + 1;
            switch (s.charAt(3)) {
                case '=':
                    if (Math.abs(value) != result)
                        return;
                    break;
                case '>':
                    if (Math.abs(value) <= result)
                        return;
                    break;
                case '<':
                    if (Math.abs(value) >= result)
                        return;
                    break;
            }
        }
        answer++;
    }
}
