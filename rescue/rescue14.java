package rescue;

// 프로그래머스
// 2XN 타일링
// https://programmers.co.kr/learn/courses/30/lessons/12900?language=java

public class rescue14{
    public static void main(String[] args){
        for(int n=1; n<=500; n++){
            // int n = 1;
    
            int answer = 0;
    
            int pre = 1;
            int next = 2;
            if(n <= 2){
                answer = n;
            } else{
                for(int i=0; i<n-2; i++){
                    answer = pre + next;
                    pre = next;
                    next = answer % 1000000007;
                }
            }   
    
            System.out.println(answer % 1000000007);

        }
    }
}