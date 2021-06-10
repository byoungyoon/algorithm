
public class Test8 {
    public static void main(String[] args){
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        long playSecond = getSecond(play_time);
        long advSecond = getSecond(adv_time);

        int[] result = new int[(int)playSecond];

        for(String log: logs){
            String[] value = log.split("-");
            int startSecond = getSecond(value[0]);
            int endSecond = getSecond(value[1]);

            for(int i=(int)startSecond; i<endSecond; i++){
                result[i] += 1;
            }
        }

        long sum = 0;
        int answer = 0;


        for(int i=0; i<=playSecond-advSecond; i++){
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

        String time = hour<10?"0"+hour+":":hour+":";
        time += min<10?"0"+min+":":min+":";
        time += second<10?"0"+second:second;

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
