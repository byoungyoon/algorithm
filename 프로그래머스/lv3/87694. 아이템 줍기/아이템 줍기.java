import java.util.*;

class Solution {
    private int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int[] item : rectangle) {
            int sX = item[0] * 2;
            int eX = item[2] * 2;
            int sY = item[1] * 2;
            int eY = item[3] * 2;

            for (int i = sX; i <= eX; i++) {
                for (int j = sY; j <= eY; j++) {
                    if ((i == sX || i == eX || j == sY || j == eY) && map[i][j] != 0)
                        map[i][j] = 1;
                    else
                        map[i][j] = 0;
                }
            }
        }

        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(characterX * 2, characterY * 2, 0));

        boolean[][] visited = new boolean[map.length][map[0].length];

        while (!queue.isEmpty()) {
            Location location = queue.poll();

            if (location.x == itemX * 2 && location.y == itemY * 2)
                return location.value / 2;

            for (int i = 0; i < direction.length; i++) {
                int nX = location.x + direction[i][0];
                int nY = location.y + direction[i][1];

                if (map[nX][nY] != 1 || visited[nX][nY])
                    continue;

                visited[nX][nY] = true;
                queue.offer(new Location(nX, nY, location.value + 1));
            }
        }

        return 0;
    }
    
    class Location {
        int x;
        int y;
        int value;

        public Location(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}