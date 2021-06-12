package basic;

// 프로그래머스
// 약수의 합

public class basic25{
    public static void main(String[] args){
        int n = 12;

        int answer = 0;

        for(int i=1; i<n/2+1; i++){
            if(n%i == 0){
                answer += i;
            }
        }

        System.out.println(answer+n);
    }
}