import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Test7 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args){
        int[] arr = {3,4,9,16};

        Test7 test = new Test7();
        System.out.println(test.solution(arr));
    }

    private int solution(int[] arr){
        int count = 3;
        int divide = 0;

        while(divide != arr.length){
            divide = 0;
            count--;
            for(int i=0; i<arr.length; i++){
                if(arr[i] % count == 0) divide++;
            }
        }

        int answer = count;
        for(int i=0; i<arr.length; i++){
            answer = answer * (arr[i] / count);
        }

        return answer;
    }
}
