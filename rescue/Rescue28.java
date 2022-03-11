package rescue;

public class Rescue28 {
    public static void main(String[] args) {
        int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
        int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };

        Rescue28 rescure = new Rescue28();
        System.out.println(rescure.solution(board, skill));
    }

    private int solution(int[][] board, int[][] skill) {
        int[][] sample = new int[board.length + 1][board[0].length + 1];

        for (int[] sk : skill) {
            int type = 1;
            if (sk[0] == 1)
                type = -1;

            sample[sk[1]][sk[2]] += sk[5] * type;
            sample[sk[3] + 1][sk[2]] += -sk[5] * type;
            sample[sk[1]][sk[4] + 1] += -sk[5] * type;
            sample[sk[3] + 1][sk[4] + 1] += sk[5] * type;
        }

        for (int i = 0; i < sample.length; i++) {
            for (int j = 1; j < sample[0].length; j++) {
                sample[i][j] += sample[i][j - 1];
            }
        }

        for (int i = 0; i < sample[0].length; i++) {
            for (int j = 1; j < sample.length; j++) {
                sample[j][i] += sample[j - 1][i];
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + sample[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}
