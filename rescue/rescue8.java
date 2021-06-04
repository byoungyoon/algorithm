package rescue;

// 프로그래머스
// 124 나라의 숫자

public class rescue8{
    public static void main(String[] args){
        int n = 14;

        StringBuilder answer = new StringBuilder();

        while(n > 0){
            int value = n/3;
            int sumValue = n%3;
            if(n % 3 == 0){
                value = value - 1;
                sumValue = 4;
            }
            answer.insert(0, sumValue);
            n = value;
        }

        System.out.println(answer.toString());
    }
}