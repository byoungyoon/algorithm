package basic;

// 프로그래머스
// 수박수박수박수박수

public class basic11{
    public static void main(String[] args){
        int n = 4;
        String[] value = {"수", "박"};

        String answer = "";
        for(int i=0; i<n; i++){
            answer += value[i%2];
        }

        System.out.println(answer);

    }
}
