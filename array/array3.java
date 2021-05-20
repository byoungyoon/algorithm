package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;

// 프로그래머스
// 모의고사

public class array3 {
    public static void main(String[] args){
        int[] answers = {1, 2, 5, 5, 2};

        int[] method1 = {1,2,3,4,5};
        int[] method2 = {2,1,2,3,2,4,2,5};
        int[] method3 = {3,3,1,1,2,2,4,4,5,5};

        int[] output = {calculation(answers, method1), calculation(answers, method2), calculation(answers, method3)};
        //System.out.println(Arrays.stream(output).boxed().collect(Collectors.toList()));
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<output.length; i++){
            int count = 3;
            for(int j: output){
                if(j <= output[i]) count = count - 1;
            }
            if(count == 0){
                answer.add(i+1);
            }
        }

        System.out.println(answer);
    }
    
    static int calculation(int[] answers, int[] method){
        
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(answers).map(data-> method[index.getAndIncrement()%method.length] == data? 1:0).sum();
    }
}
