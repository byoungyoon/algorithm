package array;

// 프로그래머스
// 가장 긴 팰린드롬
// https://programmers.co.kr/learn/courses/30/lessons/12904

public class array12 {
    public static void main(String[] args){
        String s = "abacde";

        int answer = 1;

        int count = s.length();
        while(count != 1){
            for(int i=0; i<=s.length()-count; i++){
                int size = count / 2;
                boolean same = true;
                for(int j=0; j<size; j++){
                    if(s.charAt(i+j) != s.charAt(i+count-j-1)){
                        same = false;
                        break;
                    }
                }

                if(same){
                    answer = count;
                    break;
                }
            }

            if(answer != 1) break;

            count = count - 1;
        }

        System.out.println(answer);
    }
}
