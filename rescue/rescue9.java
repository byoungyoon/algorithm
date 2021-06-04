package rescue;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스
// 다리를 지나는 트럭

public class rescue9 {
    public static void main(String[] args){
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        Queue<Judgment> q = new LinkedList<>();
        int time = 1;
        int currentWeight = truck_weights[0];
        int index = 1;
        q.offer(new Judgment(time, truck_weights[0]));

        while(!q.isEmpty()){
            time = time + 1;
            if(time - q.peek().getTime() == bridge_length){
                currentWeight = currentWeight - q.poll().getWeight();
            }
            if(index < truck_weights.length){
                if(currentWeight + truck_weights[index] <= weight){
                    q.offer(new Judgment(time, truck_weights[index]));
                    currentWeight = currentWeight + truck_weights[index];
                    index = index + 1;
                }
            }
        }

        System.out.println(time);
    }
}

class Judgment{
    private int time;
    private int weight;

    public Judgment(int time, int weight){
        this.time = time;
        this.weight = weight;
    }

    public int getTime(){
        return this.time;
    }

    public int getWeight(){
        return this.weight;
    }
}