package rescue;

// 프로그래머스
// 다음 큰 수

public class rescue10 {
    public static void main(String[] args){
        int n = 78;
        
        int count = conversion(n);
        int answer = 0;

        while(true){
            n = n+1;
            if(conversion(n) == count){
                answer = n;
                break;
            }
        }

        System.out.println(answer);
    }

    static int conversion(int n){
        int count = 0;
        while(n > 0){
            if(n%2 == 1){
                count = count + 1;
            }
            n = n/2;
        }
        return count;
    }
}
