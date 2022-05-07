package timeout;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args){
        int[] A = {2,2,2,0}; 
        int[] B = {1,1,1,1};
        
        Arrays.sort(A);
        Arrays.sort(B);

        // 7 5 3 1
        // 8 6 2 2

        boolean[] visitedA = new boolean[A.length];
        boolean[] visitedB = new boolean[B.length];

        int answer = 0;

        int count = 0;
        while(count < A.length){
            for(int i=A.length-1; i>=0; i--){
                if(visitedA[i]) continue;
                count = count + 1;
                visitedA[i] = true;
                if(A[i] >= B[i]){
                    for(int j=0; j<B.length; j++){
                        if(visitedB[j]) continue;
                        visitedB[j] = true;
                        break;
                    }
                } else{
                    for(int j=B.length-1; j>=0; j--){
                        if(visitedB[j]) continue;
                        visitedB[j] = true;
                        answer = answer + 1;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
