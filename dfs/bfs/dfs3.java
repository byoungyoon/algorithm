public class Test12 {
    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 1, 2 };
        int target = 2;

        Test12 test = new Test12();
        System.out.println(test.solution(numbers, target));
    }

    private int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, -numbers[0]);

        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int value) {
        if (depth == numbers.length - 1) {
            if (value == target) {
                answer += 1;
            }
            return;
        }

        dfs(numbers, target, depth + 1, value + numbers[depth + 1]);
        dfs(numbers, target, depth + 1, value - numbers[depth + 1]);
    }
}
