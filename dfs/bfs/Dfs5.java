package dfs.bfs;

import java.util.Arrays;

public class Dfs5 {
    static int max = Integer.MIN_VALUE;
    static int[] answer = {};

    public static void main(String[] args) {
        int n = 10;
        int[] info = { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 };

        Dfs5 dfs = new Dfs5();
        System.out.println(Arrays.toString(dfs.solution(n, info)));
    }

    private int[] solution(int n, int[] info) {
        int[] answers = new int[info.length];
        answer = new int[info.length];

        shooting(info, answers, 0, n);

        if (max <= 0)
            return new int[] { -1 };

        return answer;
    }

    private void shooting(int[] info, int[] answers, int depth, int n) {
        if (n == 0) {
            int result = compare(info, answers);

            if (result > max) {
                max = result;
                answer = answers.clone();
            } else if (result == max) {
                answer = compareSame(answers).clone();
            }

            return;
        }

        if (depth == info.length)
            return;

        answers[depth]++;
        shooting(info, answers, depth, n - 1);
        answers[depth]--;
        shooting(info, answers, depth + 1, n);
    }

    private int compare(int[] info, int[] answers) {
        int ap = 0;
        int li = 0;

        for (int i = 0; i < info.length; i++) {
            if (answers[i] == 0 && info[i] == 0)
                continue;

            if (answers[i] > info[i]) {
                li += 10 - i;
            } else {
                ap += 10 - i;
            }
        }

        return li - ap;
    }

    private int[] compareSame(int[] answers) {
        for (int i = answers.length - 1; i >= 0; i--) {
            if (answers[i] > 0 && answer[i] > 0) {
                return answers[i] > answer[i] ? answers : answer;
            } else if (answers[i] > 0)
                return answers;
            else if (answer[i] > 0)
                return answer;
        }

        return answers;
    }
}
