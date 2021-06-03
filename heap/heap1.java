package heap;
import java.util.Arrays;
import java.util.stream.Collectors;

// 프로그래머스
// 더 맵게
// 효율성 실패.. 좀 더 보완

public class heap1 {
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int answer = 0;
        
        while(true){
            for(int i=scoville.length/2-1; i>=0; i--){
                heapify(scoville, scoville.length, i);
            }
            
            for(int i=scoville.length-1; i>0; i--){
                swap(scoville, i, 0);
                heapify(scoville, i, 0);
            }
            
            if(scoville[0] >= k) break;
            if(scoville.length == 1){
                answer = -1;
                break;
            }
    
            scoville[1] = scoville[0] + scoville[1]*2;
            scoville = Arrays.copyOfRange(scoville, 1, scoville.length);

            answer = answer + 1;
        }

        System.out.println(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        System.out.println(answer);

    }
    static void heapify(int[] scoville, int size, int pNode){
        int parent = pNode;
        int lNode = pNode*2 + 1;
        int rNode = pNode*2 + 2;

        if(size > lNode && scoville[parent] < scoville[lNode]){
            parent = lNode;
        }

        if(size > rNode && scoville[parent] < scoville[rNode]){
            parent = rNode;
        }

        if(parent != pNode){
            swap(scoville, pNode, parent);

            heapify(scoville, size, parent);
        }
    }

    static void swap(int scoville[], int i, int j){
        int temp = scoville[i];
        scoville[i] = scoville[j];
        scoville[j] = temp;
    }
}
