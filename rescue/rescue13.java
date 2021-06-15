package rescue;

// 프로그래머스
// 기지국 설치

public class rescue13 {
    public static void main(String[] args){
        int n = 16;
        int[] stations = {9};
        int w = 2;

        int answer = 0;

        int start = 0;
        int end = 0;
        for(int i=0; i<stations.length; i++){
            start = stations[i] - w - 1;
            int value = start - end;
            if(value > 0){
                answer += value / (2 * w + 1);
                if(value % (2 * w + 1) != 0) answer = answer + 1;
            }

            end = stations[i] + w;
        }

        if(end < n){
            answer += (n - end) / (2 * w + 1);
            if((n - end) % (2 * w + 1) != 0) answer = answer + 1;
        }

        System.out.println(answer);
    }
}
