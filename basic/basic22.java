package basic;

// 프로그래머스
// 두 정수 사이의 합

public class basic22 {
    public static void main(String[] args){
        int a = 5;
        int b = 3;

        Long answer = 0L;

        if(a < b){
            for(int i=a; i<=b; i++){
                answer += i;
            }
        } else{
            for(int i=b; i<=a; i++){
                answer += i;
            }
        }

        System.out.println(answer);
    }
}
