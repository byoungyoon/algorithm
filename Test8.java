import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test8 {
    public static void main(String[] args){
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                            "2016-09-15 20:59:58.233 1.181s",
                            "2016-09-15 20:59:58.299 0.8s",
                            "2016-09-15 20:59:58.688 1.041s",
                            "2016-09-15 20:59:59.591 1.412s",
                            "2016-09-15 21:00:00.464 1.466s",
                            "2016-09-15 21:00:00.741 1.581s",
                            "2016-09-15 21:00:00.748 2.31s",
                            "2016-09-15 21:00:00.966 0.381s",
                            "2016-09-15 21:00:02.066 2.62s"
                        };

        Map<Integer, Integer> hm = new HashMap<>();
        
        for(String line: lines){
            String[] split = line.split(" ");

            String[] timeSplit = split[1].split(":|\\.");
            int hour = Integer.parseInt(timeSplit[0]);
            int min = Integer.parseInt(timeSplit[1]);
            int second = hour*24*60 + min*60 + Integer.parseInt(timeSplit[2]);
            Float mills = Integer.parseInt(timeSplit[3]) / (float)1000;
            Float addSecond = Float.parseFloat(split[2].substring(0, split[2].length()-1));

            System.out.println(second);
            System.out.println(addSecond+mills);

            int count = 0;
            while(addSecond+mills > 0){
                addSecond = addSecond - 1;
                count++;
            }
            
            for(int i=0; i<count; i++){
                hm.put(second+i, hm.getOrDefault(second+i, 0) + 1);
            }

        }

        System.out.println(hm);
    }   

}
