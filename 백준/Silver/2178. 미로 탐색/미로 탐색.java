import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Main test = new Main();
        System.out.println(test.solution(map));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int solution(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] index = q.poll();

            if (index[0] == map.length - 1 && index[1] == map[0].length - 1) {
                return index[2];
            }

            for (int i = 0; i < direction.length; i++) {
                int nY = index[0] + direction[i][0];
                int nX = index[1] + direction[i][1];

                if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length
                        || map[nY][nX] == 0 || visited[nY][nX])
                    continue;
                visited[nY][nX] = true;
                q.add(new int[] { nY, nX, index[2] + 1 });
            }

        }

        return 1;
    }
}
