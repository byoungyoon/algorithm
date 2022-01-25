public class Test9 {
    public static void main(String[] args) {
        int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 }, { 6, 5 },
                { 4, 6 }, { 8, 9 } };

        Test9 test = new Test9();
        System.out.println(test.solution(info, edges));
    }

    private int solution(int[] info, int[][] edges) {
        int answer = 0;
        return answer;
    }
}
