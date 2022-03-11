package dfs.bfs;

public class Dfs6 {
    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) {
        int[][] board = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int[] aloc = { 1, 0 };
        int[] bloc = { 1, 2 };

        Dfs6 dfs = new Dfs6();
        System.out.println(dfs.solution(board, aloc, bloc));
    }

    private int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0).count;
    }

    class Game {
        public boolean win;
        public int count;

        public Game(boolean win, int count) {
            this.win = win;
            this.count = count;
        }

        @Override
        public String toString() {
            return "win : " + win + ", count : " + count;
        }
    }

    private Game dfs(int[][] board, int y1, int x1, int y2, int x2, int depth) {
        boolean win = false;
        int min = 5 * 5;
        int max = depth;

        if (board[y1][x1] == 1) {
            for (int[] dir : direction) {
                int nextY = y1 + dir[0];
                int nextX = x1 + dir[1];

                if (nextY < 0 || nextX < 0 || nextY >= board.length || nextX >= board[0].length)
                    continue;
                if (board[nextY][nextX] == 0)
                    continue;

                board[y1][x1] = 0;

                Game game = dfs(board, y2, x2, nextY, nextX, depth + 1);
                win |= !game.win;

                if (game.win)
                    max = Math.max(max, game.count);
                else
                    min = Math.min(min, game.count);

                board[y1][x1] = 1;
            }
        }

        return new Game(win, win ? min : max);
    }
}
