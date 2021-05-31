package rescue;

// 프로그래머스
// 점프와 순간 이동

public class rescue5 {
    public static void main(String[] args){
        int n = 5;

        int answer = 0;
        while(n > 0){
            if(n%2 == 0){
                n = n/2;
            } else{
                n = n-1;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
