import java.util.Arrays;

public class Test8 {
    public static void main(String[] args){
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        int playSecond = getSecond(play_time);
        int advSecond = getSecond(adv_time);

        int[] result = new int[playSecond];

        for(String log: logs){
            String[] value = log.split("-");
            int startSecond = getSecond(value[0]);
            int endSecond = getSecond(value[1]);

            for(int i=startSecond; i<endSecond; i++){
                result[i] += 1;
            }
        }

        int sum = 0;
        int answer = 0;

        for(int i=0; i<playSecond-advSecond; i++){
            int count = 0;
            for(int j=i; j<advSecond+i; j++){
                count += result[j];
            }
            if(sum < count){
                sum = count;
                answer = i;
            }
        }

        int hour = answer / (60*60);
        int min = answer / 60 % 60;
        int second = answer % 60;

        String time = "";

        time = time + hour;
        if(hour < 10){
            time = "0" + time;
        }
        time = time + ":";
        
        time = time + min;
        if(min < 10){
            time = "0" + time;
        }
        time = time + ":";

        time = time + second;
        if(second < 10){
            time = "0" + time;
        }
        time = time + ":";

        System.out.println(time);
    }

    static int getSecond(String time){
        String[] value = time.split(":");
        
        int hour = Integer.parseInt(value[0])*60*60;
        int min = Integer.parseInt(value[1])*60;
        int second = hour + min + Integer.parseInt(value[2]);
        
        return second;
    }

}
