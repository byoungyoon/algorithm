package kakao2018;

// https://school.programmers.co.kr/learn/courses/30/lessons/17679

public class Kakao7 {
    public static void main(String[] args) {
        int m = 6;
        int n = 5;
        String[] board = { "CCZXZ", "CCZXZ", "XXZXZ", "AAZAA", "AAAAA", "ZAAXX" };

        Kakao7 test = new Kakao7();
        System.out.println(test.solution(m, n, board));
    }

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean[][] visited;
        int answer = 0;
        while (true) {
            visited = new boolean[m][n];
            boolean check = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!onCheck(map, i, j))
                        continue;

                    visited[i][j] = true;
                    visited[i + 1][j] = true;
                    visited[i][j + 1] = true;
                    visited[i + 1][j + 1] = true;

                    check = true;
                }
            }

            if (check) {
                for (int i = 0; i < n; i++) {
                    for (int j = m - 1; j >= 0; j--) {
                        if (!visited[j][i]) {
                            int count = 0;
                            for (int z = j + 1; z < m; z++) {
                                if (map[z][i] == '.') {
                                    count++;
                                } else
                                    break;
                            }
                            char temp = map[j][i];
                            map[j][i] = '.';
                            map[j + count][i] = temp;

                            continue;
                        }

                        map[j][i] = '.';
                        answer++;
                    }
                }
            } else
                break;
        }

        return answer;
    }

    public boolean onCheck(char[][] map, int y, int x) {
        char target = map[y][x];

        if (target != '.' && map[y + 1][x] == target && map[y][x + 1] == target && map[y + 1][x + 1] == target) {
            return true;
        }

        return false;
    }
}