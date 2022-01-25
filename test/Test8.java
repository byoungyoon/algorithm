public class Test8 {
    public static void main(String[] args) {
        // 앞에 값
        int n = 10;

        int trueValue = 0;
        int falseValue = 0;

        while (true) {
            if (trueValue == 5) {
                // 5개 이상 맞춤
                // 단 변경
                n = 3;
            } else if (falseValue == 3) {
                // 3게 이상 틀림
                System.out.println("게임 종료");
                break;
            }
            // 뒤에 값
            int m = 10;
            int result = n * m;

            // 입력 받을 값
            int k = 100;
            if (result == k) {
                trueValue = trueValue + 1;
            } else {
                falseValue = falseValue + 1;
            }

            // 특정값 입력하면 종료
            if (m == 0) {
                break;
            }
            // 끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝끝
        }

    }
}