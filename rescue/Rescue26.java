package rescue;

public class Rescue26 {
    private int[][] board;
    private int len;

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0 }, { 3, 0, 0, 2, 0 }, { 3, 2, 2, 2, 0 },
                { 3, 3, 0, 0, 0 } };

        Rescue26 rescue = new Rescue26();
        System.out.println(rescue.solution(board));
    }

    private int solution(int[][] board) {
        this.board = board;
        this.len = board.length;

        int answer = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 0)
                    continue;

                if (typeA(i, j)) {
                    if (drop(j + 1, board[i][j]) && drop(j + 2, board[i][j])) {
                        remove(i, j, i + 1, j, i + 1, j + 1, i + 1, j + 2);
                        answer++;
                        j = -1;
                    }
                } else if (typeB(i, j)) {
                    if (drop(j - 1, board[i][j]) && drop(j + 1, board[i][j])) {
                        remove(i, j, i + 1, j - 1, i + 1, j, i + 1, j + 1);
                        answer++;
                        j = -1;
                    }
                } else if (typeC(i, j)) {
                    if (drop(j - 2, board[i][j]) && drop(j - 1, board[i][j])) {
                        remove(i, j, i + 1, j - 2, i + 1, j - 1, i + 1, j);
                        answer++;
                        j = -1;
                    }
                } else if (typeD(i, j)) {
                    if (drop(j + 1, board[i][j])) {
                        remove(i, j, i + 1, j, i + 2, j, i + 2, j + 1);
                        answer++;
                        j = -1;
                    }
                } else if (typeE(i, j)) {
                    if (drop(j - 1, board[i][j])) {
                        remove(i, j, i + 1, j, i + 2, j, i + 2, j - 1);
                        answer++;
                        j = -1;
                    }
                }
            }
        }

        return answer;
    }

    private boolean drop(int x, int value) {
        for (int i = 0; i < len; i++) {
            if (board[i][x] == 0)
                continue;
            if (board[i][x] == value)
                return true;
            else {
                return false;
            }
        }
        return false;
    }

    private void remove(int y1, int x1, int y2, int x2, int y3, int x3, int y4, int x4) {
        board[y1][x1] = 0;
        board[y2][x2] = 0;
        board[y3][x3] = 0;
        board[y4][x4] = 0;
    }

    /*
     * 1 0 0
     * 1 1 1
     */
    private boolean typeA(int y, int x) {
        int num = board[y][x];
        if (x + 2 >= len || y + 1 >= len)
            return false;
        return num == board[y + 1][x] && num == board[y + 1][x + 1] && num == board[y + 1][x + 2];
    }

    /*
     * 0 1 0
     * 1 1 1
     */
    private boolean typeB(int y, int x) {
        int num = board[y][x];
        if (x - 1 < 0 || x + 1 >= len || y + 1 >= len)
            return false;
        return num == board[y + 1][x - 1] && num == board[y + 1][x] && num == board[y + 1][x + 1];
    }

    /*
     * 0 0 1
     * 1 1 1
     */
    private boolean typeC(int y, int x) {
        int num = board[y][x];
        if (x - 2 < 0 || y + 1 >= len)
            return false;
        return num == board[y + 1][x - 2] && num == board[y + 1][x - 1] && num == board[y + 1][x];
    }

    /*
     * 1 0
     * 1 0
     * 1 1
     */
    private boolean typeD(int y, int x) {
        int num = board[y][x];
        if (x + 1 >= len || y + 2 >= len)
            return false;
        return num == board[y + 1][x] && num == board[y + 2][x] && num == board[y + 2][x + 1];
    }

    /*
     * 0 1
     * 0 1
     * 1 1
     */
    private boolean typeE(int y, int x) {
        int num = board[y][x];
        if (x - 1 < 0 || y + 2 >= len)
            return false;
        return num == board[y + 1][x] && num == board[y + 2][x] && num == board[y + 2][x - 1];
    }

}
