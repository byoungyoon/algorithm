package basic;
// 프로그래머스
// 콜라츠 추측

public class basic8 {
    public static void main(String[] args){
        int num = 1;

        System.out.println(collatz(num));
    }

    static int collatz(int num){
        int count = 0;
        Long numLong = Long.valueOf(num);

        if(num == 1) return 0;

        while(count < 500){
            if(numLong % 2 ==0){
                numLong = numLong / 2;
            } else{
                numLong = numLong*3 + 1;
            }

            count++;
            if(numLong == 1){
                return count;
            }
        }

        return -1;
    }
}
