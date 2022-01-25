import java.util.Arrays;

public class Test11 {
    public static void main(String[] args) {
        int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };

        Test11 test = new Test11();
        System.out.println(Arrays.toString(test.solution(line)));
    }

    public String[] solution(int[][] line) {
        String[] answer = {};
        boolean[] visited = new boolean[line.length];

        combination(line, visited, 0, 2);

        return answer;
    }

    public void combination(int[][] line, boolean[] visited, int depth, int r) {
        if (r == 0) {
            for (int i = 0; i < line.length; i++) {
                if (!visited[i])
                    continue;

                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if (depth == line.length)
            return;

        visited[depth] = true;
        combination(line, visited, depth + 1, r - 1);
        visited[depth] = false;
        combination(line, visited, depth + 1, r);
    }
}
