package dfs.bfs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Dfs4 {
    static int count = 0;

    public static void main(String[] args) {
        int m = 13;
        int n = 16;
        int[][] picture = { { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 } };

        Dfs4 dfs = new Dfs4();
        System.out.println(Arrays.stream(dfs.solution(m, n, picture)).boxed().collect(Collectors.toList()));
    }

    private int[] solution(int m, int n, int[][] picture) {
        boolean[][] check = new boolean[m][n];
        int y = 0;
        int x = 0;

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0)
                    continue;
                if (check[i][j])
                    continue;

                y = i;
                x = j;
                quest(x, y, picture[y][x], picture, check);

                if (count > maxSizeOfOneArea)
                    maxSizeOfOneArea = count;
                count = 0;
                numberOfArea++;
            }
        }

        int[] answer = { numberOfArea, maxSizeOfOneArea };

        return answer;
    }

    private void quest(int x, int y, int value, int[][] picture, boolean[][] check) {
        if (check[y][x])
            return;
        if (value != picture[y][x])
            return;
        check[y][x] = true;
        count++;

        if (x + 1 < picture[0].length) {
            quest(x + 1, y, picture[y][x], picture, check);
        }
        if (y + 1 < picture.length) {
            quest(x, y + 1, picture[y][x], picture, check);
        }
        if (x - 1 >= 0) {
            quest(x - 1, y, picture[y][x], picture, check);
        }
        if (y - 1 >= 0) {
            quest(x, y - 1, picture[y][x], picture, check);
        }
    }
}