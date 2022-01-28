package array;

import java.util.Arrays;

public class Array19 {
    public static void main(String[] args) {
        int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
        int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        Array19 test = new Array19();
        System.out.println(test.solution(key, lock));
    }

    private boolean solution(int[][] key, int[][] lock) {
        int[][] locks = new int[(key.length - 1) * 2 + lock.length][(key.length - 1) * 2 + lock.length];

        for (int i = 0; i < locks.length; i++) {
            Arrays.fill(locks[i], -1);
        }

        int counting = 0;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[0].length; j++) {
                locks[i + key.length - 1][j + key.length - 1] = lock[i][j];
                if (lock[i][j] == 0)
                    counting++;
            }
        }

        boolean answer = false;
        int[] start = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < locks.length - key.length + 1; j++) {
                for (int z = 0; z < locks[0].length - key[0].length + 1; z++) {
                    start[0] = j;
                    start[1] = z;
                    if (judgment(key, locks, start, counting))
                        return true;

                }
            }

            key = swing(key);
        }

        return answer;
    }

    private int[][] swing(int[][] keys) {
        int[][] result = new int[keys.length][keys[0].length];
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys[0].length; j++) {
                result[i][j] = keys[keys.length - 1 - j][i];
            }
        }

        return result;
    }

    private boolean judgment(int[][] key, int[][] locks, int[] start, int counting) {
        for (int i = start[0]; i < start[0] + key.length; i++) {
            for (int j = start[1]; j < start[1] + key[0].length; j++) {
                if (locks[i][j] == 0) {
                    counting--;
                    if (key[i - start[0]][j - start[1]] == 0) {
                        return false;
                    }
                } else if (locks[i][j] == 1 && key[i - start[0]][j - start[1]] == 1)
                    return false;

            }
        }

        if (counting != 0)
            return false;

        return true;
    }
}
