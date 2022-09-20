package dp3;

// https://school.programmers.co.kr/learn/courses/30/lessons/1832

public class Dp1 {
    public static void main(String[] args) {
        // int m = 3;
        // int n = 3;
        // int[][] cityMap = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        int m = 3;
        int n = 6;
        int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };

        Dp1 test = new Dp1();
        System.out.println(test.solution(m, n, cityMap));
    }

    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] map = new int[m][n];
        for (int i = 0; i < map[0].length; i++) {
            if (cityMap[0][i] == 1)
                break;
            map[0][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            if (cityMap[i][0] == 1)
                break;
            map[i][0] = 1;
        }

        map[0][0] = 1;

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (cityMap[i][j] == 1)
                    continue;

                int pY = i - 1;
                int pX = j - 1;

                boolean cY = true;
                boolean cX = true;

                while (cityMap[pY][j] == 2) {
                    pY--;

                    if (pY < 0) {
                        cY = false;
                        break;
                    }
                }

                while (cityMap[i][pX] == 2) {
                    pX--;

                    if (pX < 0) {
                        cX = false;
                        break;
                    }
                }

                if (cY)
                    map[i][j] += map[pY][j];

                if (cX)
                    map[i][j] += map[i][pX];

                map[i][j] = map[i][j] % MOD;
            }
        }

        return map[m - 1][n - 1];
    }
}
