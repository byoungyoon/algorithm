import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

// 프로그래머스
// 로또의 최고 순위와 최저 순위

class Programmers1{
    public static void main(String[] args){
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int[] ranking = {6,6,5,4,3,2,1};

        HashMap<Integer, Integer> hm = new HashMap<>();
        putMap(lottos, hm);
        putMap(win_nums, hm);

        int value = 0;
        int zeroValue = 0;

        for(Integer key : hm.keySet()){
            if(key == 0){
                zeroValue = hm.get(key);
            } else{
                if(hm.get(key) == 2){
                    value++;
                }
            }
        }
        
        int[] answer = {ranking[value+zeroValue], ranking[value]};

        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
    }

    static void putMap(int[] arrays, HashMap<Integer, Integer> hm){
        for(int i : arrays){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
    }
}
