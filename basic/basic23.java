package basic;

// 프로그래머스
// 숫자의 표현

public class basic23 {
    static int answer = 1;
    public static void main(String[] args){
        int n = 15;

        for(int i=1; i<n/2+1; i++){
            int count = i+1;
            int current = i;
            while(current < n){
                current += count;
                count = count + 1;
                if(current == n){
                    answer = answer + 1;
                }
            }
        }

        System.out.println(answer);
    }
}
