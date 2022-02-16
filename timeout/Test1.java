package timeout;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    static Queue<Location> q = new LinkedList<>();
    static int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int[][] map = {};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };
        // 직선 100, 코너 500

        Test1 test = new Test1();
        System.out.println(test.solution(board));
    }

    private int solution(int[][] board) {
        map = new int[board.length][board[0].length];

        boolean[][] visited = new boolean[board.length][board[0].length];

        q.offer(new Location(0, 1, 0, 0, 100));
        q.offer(new Location(0, 0, 1, 0, 100));

        race(board, visited);

        return answer;
    }

    private void race(int[][] board, boolean[][] visited) {
        if (q.isEmpty())
            return;

        Location location = q.poll();

        if (location.getX() == board[0].length - 1 && location.getY() == board[1].length - 1) {
            answer = answer < location.getFee() ? answer : location.getFee();
            return;
        }

        for (int i = 0; i < direction.length; i++) {
            int nextY = location.getY() + direction[i][0];
            int nextX = location.getX() + direction[i][1];

            if (nextX < 0 || nextX >= board[0].length || nextY < 0 || nextY >= board.length)
                continue;

            if (board[nextY][nextX] == 1)
                continue;

            int fee = location.getFee();
            if (corner(location.getPreY(), location.getPreX(), nextY, nextX)) {
                fee += 600;
            } else {
                fee += 100;
            }

            if (visited[nextY][nextX])
                continue;

            q.offer(new Location(nextY, nextX, location.getY(), location.getX(), fee));
        }
        race(board, visited);
    }

    private boolean corner(int preY, int preX, int nextY, int nextX) {
        if (preX - nextX == 0)
            return false;
        if (preY - nextY == 0)
            return false;

        return true;
    }
}

class Location {
    private int y;
    private int x;
    private int preY;
    private int preX;
    private int fee;

    public Location(int y, int x, int preY, int preX, int fee) {
        this.y = y;
        this.x = x;
        this.preY = preY;
        this.preX = preX;
        this.fee = fee;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getPreY() {
        return this.preY;
    }

    public int getPreX() {
        return this.preX;
    }

    public int getFee() {
        return this.fee;
    }

}